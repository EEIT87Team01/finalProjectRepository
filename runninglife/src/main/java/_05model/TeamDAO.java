package _05model;

import java.util.List;

public interface TeamDAO {
    public void insert(TeamVO teamVO);
    public void update(TeamVO teamVO);
    public void delete(Integer contestID,Integer eventID,Integer teamID);
    public TeamVO findByPrimaryKey(Integer contestID,Integer eventID,Integer teamID);
    public List<TeamVO> getAll();
    //查詢某部門的員工(一對多)(回傳 Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
