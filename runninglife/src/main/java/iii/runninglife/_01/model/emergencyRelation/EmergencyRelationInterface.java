package iii.runninglife._01.model.emergencyRelation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface EmergencyRelationInterface {
	public void insert(EmergencyRelationVO emergencyRelationVO);
	public void update(EmergencyRelationVO emergencyRelationVO);
	public void delete(int emergencyRelationVO);
	public EmergencyRelationVO selectOne(int emergencyRelationVO);
	public List<EmergencyRelationVO> selectAll(EmergencyRelationVO emergencyRelationVO);
}
