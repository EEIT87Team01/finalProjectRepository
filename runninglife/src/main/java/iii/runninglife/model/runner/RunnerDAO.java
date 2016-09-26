package iii.runninglife.model.runner;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.model.contest.ContestVO;
import iii.runninglife.model.members.MembersVO;
@Transactional
public interface RunnerDAO {
	public String insert(RunnerVO runnerVO);
	public void update(RunnerVO runnerVO);
	public void delete(RunnerPK pk);
	public RunnerVO findByPrimaryKey(RunnerPK pk);
	public List<RunnerVO> getAll();
	public void updateAll(RunnerForm runnerForm);
	public List<RunnerVO> getScoreGroup(Integer contestID ,Integer eventID, Integer teamID);
	public List<RunnerVO> getEventGroup(Integer eventID);
	public List<RunnerVO> getTeamGroup(Integer teamID);
	public List<RunnerVO> getMyContest(MembersVO memberID);
	public List<RunnerVO> getList(ContestVO contestID);
}
