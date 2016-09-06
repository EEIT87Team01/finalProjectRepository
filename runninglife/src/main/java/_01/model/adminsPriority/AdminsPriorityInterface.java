package _01.model.adminsPriority;

import java.util.List;

public interface AdminsPriorityInterface {
	public int insert(AdminsPriorityVO adminsPriorityVO);
	public int update(AdminsPriorityVO adminsPriorityVO);
	public int delete(String adminsPriorityVO);
	public AdminsPriorityVO selectOne(String adminsPriorityVO);
	public List<AdminsPriorityVO> selectAll();
}
