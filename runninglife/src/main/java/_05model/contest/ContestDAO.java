package _05model.contest;

import java.util.List;

public interface ContestDAO {
    public void insert(ContestVO contestVO);
    public void update(ContestVO contestVO);
    public void delete(Integer contestID);
    public ContestVO findByPrimaryKey(Integer contestID);
    public List<ContestVO> getAll();
    //查詢某部門的員工(一對多)(回傳 Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
