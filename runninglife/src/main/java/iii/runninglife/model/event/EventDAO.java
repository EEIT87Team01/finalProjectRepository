package iii.runninglife.model.event;

import java.util.List;

import iii.runninglife.model.contest.ContestVO;

public interface EventDAO {
    public void insert(EventVO eventVO);
    public void update(EventVO contestVO);
    public void delete(Integer eventID);
    public EventVO findByPrimaryKey(Integer eventID);
    public List<EventVO> getAll();
    public List<EventVO> getEventById(ContestVO contestID);
    
    //查詢某部門的員工(一對多)(回傳 Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
