package _05model.clothes;

import java.util.List;

public interface ClothesDAO {
    public void insert(ClothesVO clothesVO);
    public void update(ClothesVO clothesVO);
    public void delete(String clothesSize);
    public ClothesVO findByPrimaryKey(String clothesSize);
    public List<ClothesVO> getAll();
    //查詢某部門的員工(一對多)(回傳 Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
