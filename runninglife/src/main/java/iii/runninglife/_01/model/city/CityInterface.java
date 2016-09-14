package iii.runninglife._01.model.city;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CityInterface {
	public void insert(CityVO cityVO);
	public void update(CityVO cityVO);
	public void delete(CityPK cityPK);
	public CityVO selectOne(CityPK cityPK);
	public List<CityVO> selectAll();
}
