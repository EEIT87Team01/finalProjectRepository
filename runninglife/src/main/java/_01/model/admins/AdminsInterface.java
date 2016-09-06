package _01.model.admins;

import java.util.List;

public interface AdminsInterface {
	public int insert(AdminsVO adminsVO);
	public int update(AdminsVO adminsVO);
	public int delete(String adminsVO);
	public AdminsVO selectOne(String adminsVO);
	public List<AdminsVO> selectAll();
}
