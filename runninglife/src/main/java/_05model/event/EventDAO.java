package _05model.event;

import java.util.List;

public interface EventDAO {
    public void insert(EventVO eventVO);
    public void update(EventVO contestVO);
//    public void delete(Integer contestID,Integer eventID);
//    public EventVO findByPrimaryKey(Integer contestID,Integer eventID);
    public EventVO findByPrimaryKey(EventPK pk);
    public List<EventVO> getAll();
    //查詢某部門的員工(一對多)(回傳 Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer deptno);
	void delete(EventPK pk);
}
