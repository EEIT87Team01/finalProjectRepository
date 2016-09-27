package iii.runninglife.model.runner;

import java.util.List;

public interface RunnerDAO {
	public String insert(RunnerVO runnerVO);
	public void update(RunnerVO runnerVO);
	public void delete(RunnerPK pk);
	public RunnerVO findByPrimaryKey(RunnerPK pk);
	public List<RunnerVO> getAll();
	public void updateAll(RunnerForm runnerForm);
	public List<RunnerVO> getList(Integer contestID);
	public List<RunnerVO> getMyContest(String memberID);
	public List<RunnerVO> getScoreGroup(Integer contestID ,Integer eventID, Integer teamID);
	public List<RunnerVO> getEventGroup(Integer eventID);
	public List<RunnerVO> getTeamGroup(Integer teamID);
}
