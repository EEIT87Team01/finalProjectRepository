package iii.runninglife.model.runner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunnerService {
	
	@Autowired
	private RunnerDAO runnerDAO;
	
	
	public List <RunnerVO> getMyContestByDate(String memberID,Date begin,Date end){
		List<RunnerVO> list = runnerDAO.getMyContest(memberID);
		List<RunnerVO> runner = new ArrayList<RunnerVO>();
		begin.getTime();
		end.getTime();
		System.out.println("開始:"+begin);
		System.out.println("結束:"+end);
		System.out.println("---------------------------------------");
		for(RunnerVO a:list){
			a.getContest().getStartDate().getTime();
			
			if(begin.getTime()<a.getContest().getStartDate().getTime()&&a.getContest().getStartDate().getTime()<end.getTime()){
			runner.add(a);
			System.out.println("符合的賽事:"+a.getContest().getContestName());
			}
		}
		return runner;
	}
	public void updateAllRunner(RunnerForm runnerForm,Integer pageSize){
		int lengh = runnerForm.getRunners().size();
		int index = lengh - pageSize;
		System.out.println(index);
		for (int i = 0; i < index; i++) {
			runnerForm.getRunners().remove(0);
		}
		runnerDAO.updateAll(runnerForm);
	}
	public int countAge(String birth){
		Long duration=System.currentTimeMillis()-Date.valueOf(birth).getTime();
		int age=(int) (duration/1000/60/60/24/365);
		return age;
	}
}