package iii.runninglife.model.team;

import java.util.List;

import iii.runninglife.model.contest.ContestVO;

public interface TeamDAO {
    public void insert(TeamVO teamVO);
    public void update(TeamVO teamVO);
    public void delete(Integer teamID);
    public TeamVO findByPrimaryKey(Integer teamID);
    public List<TeamVO> getAll();
    public List<TeamVO> getTeamById(ContestVO contestID);
}
