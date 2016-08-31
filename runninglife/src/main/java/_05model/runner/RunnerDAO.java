package _05model.runner;

import java.util.List;

public interface RunnerDAO {
    public void insert(RunnerVO runnerVO);
    public void update(RunnerVO runnerVO);
    public void delete(Integer contestID,Integer memberID);
    public RunnerVO findByPrimaryKey(Integer contestID,Integer memberID);
    public List<RunnerVO> getAll();
    //查詢某部門的員工(一對多)(回傳 Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
