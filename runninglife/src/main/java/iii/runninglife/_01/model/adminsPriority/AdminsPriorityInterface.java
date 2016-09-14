package iii.runninglife._01.model.adminsPriority;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AdminsPriorityInterface {
	public void insert(AdminsPriorityVO adminsPriorityVO);
	public void update(AdminsPriorityVO adminsPriorityVO);
	public void delete(String adminsPriorityVO);
	public AdminsPriorityVO selectOne(String adminsPriorityVO);
	public List<AdminsPriorityVO> selectAll();
}
