package iii.runninglife._01.model.admins;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AdminsInterface {
	public void insert(AdminsVO adminsVO);
	public void update(AdminsVO adminsVO);
	public void delete(String adminsVO);
	public AdminsVO selectOne(String adminsVO);
	public List<AdminsVO> selectAll();
}
