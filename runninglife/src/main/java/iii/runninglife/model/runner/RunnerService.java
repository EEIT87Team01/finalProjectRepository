package iii.runninglife.model.runner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.model.members.MembersInterface;
@Service
public class RunnerService {
	
	@Autowired
	private RunnerDAO runnerDAO;
	@Autowired
	private MembersInterface membersDAO;
	
	
	public List <RunnerVO> getMyContestByDate(String memberID,Date begin,Date end){
//		List<RunnerVO> list = runnerDAO.getMyContest("arthur");
		List<RunnerVO> list = runnerDAO.getMyContest(membersDAO.selectOne(memberID));
		List<RunnerVO> runner = new ArrayList<RunnerVO>();
		begin.getTime();
		end.getTime();
		System.out.println("開始:"+begin);
		System.out.println("結束:"+end);
		System.out.println("---------------------------------------");
		for(RunnerVO a:list){
			a.getRunnerPK().getContestID().getStartDate().getTime();
			
			if(begin.getTime()<a.getRunnerPK().getContestID().getStartDate().getTime()&&a.getRunnerPK().getContestID().getStartDate().getTime()<end.getTime()){
			runner.add(a);
			System.out.println("符合的賽事:"+a.getRunnerPK().getContestID().getContestName());
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
}
