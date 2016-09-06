package _01.model.emergencyRelation;

import java.util.List;

public interface EmergencyRelationInterface {
	public int insert(EmergencyRelationVO emergencyRelationVO);
	public int update(EmergencyRelationVO emergencyRelationVO);
	public int delete(int emergencyRelationVO);
	public EmergencyRelationVO selectOne(int emergencyRelationVO);
	public List<EmergencyRelationVO> selectAll(EmergencyRelationVO emergencyRelationVO);
}
