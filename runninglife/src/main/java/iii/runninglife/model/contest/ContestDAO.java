package iii.runninglife.model.contest;

import java.sql.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
public interface ContestDAO {
    public void insert(ContestVO contestVO);
    public void update(ContestVO contestVO);
    public void delete(Integer contestID);
    public ContestVO findByPrimaryKey(Integer contestID);
    public List<ContestVO> getAll();
    public List<ContestVO> page(Integer page);
    public int countPage();
    public List<ContestVO> date(String memberID,Date stDate, Date edDate);
    public List<ContestVO> date2(Date stDate, Date edDate,Integer page) ;
    public int countPageBetweenDate(Integer year, Integer month);
    //查詢某部門的員工(一對多)(回傳 Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
