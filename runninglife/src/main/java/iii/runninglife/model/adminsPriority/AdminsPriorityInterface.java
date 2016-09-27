package iii.runninglife.model.adminsPriority;

import java.util.List;

public interface AdminsPriorityInterface {
	public void insert(AdminsPriorityVO adminsPriorityVO);
	public void update(AdminsPriorityVO adminsPriorityVO);
	public void delete(String adminsPriorityVO);
	public AdminsPriorityVO selectOne(String adminsPriorityVO);
	public List<AdminsPriorityVO> selectAll();
}
