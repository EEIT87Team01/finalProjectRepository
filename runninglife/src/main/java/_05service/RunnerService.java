package _05service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _05model.runner.RunnerDAO;
import _05model.runner.RunnerDAOimpl;
import _05model.runner.RunnerVO;
@Service
public class RunnerService {
	
	@Autowired
	private RunnerDAO runnerDAO;
	
	
	public List <RunnerVO> getMyContestByDate(String memberID,Date begin,Date end){
		List<RunnerVO> list = runnerDAO.getMyContest("arthur");
//		List<RunnerVO> list = dao.getMyContest(memberID);
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
}
