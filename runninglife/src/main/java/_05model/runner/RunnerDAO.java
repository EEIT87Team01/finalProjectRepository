package _05model.runner;

import java.util.List;

public interface RunnerDAO {
	public String insert(RunnerVO runnerVO);

	public void update(RunnerVO runnerVO);

	// public void delete(RunnerVO runnerVO);
	public void delete(RunnerPK pk);

	// public RunnerVO findByPrimaryKey(RunnerVO runnerVO);
	public RunnerVO findByPrimaryKey(RunnerPK pk);

	public List<RunnerVO> getAll();
	// 查詢某部門的員工(一對多)(回傳 Set)
	// public Set<EmpVO> getEmpsByDeptno(Integer deptno);

}
