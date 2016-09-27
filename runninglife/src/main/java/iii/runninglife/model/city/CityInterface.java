package iii.runninglife.model.city;

import java.util.List;

public interface CityInterface {
	public void insert(CityVO cityVO);
	public void update(CityVO cityVO);
	public void delete(CityPK cityPK);
	public CityVO selectOne(CityPK cityPK);
	public List<CityVO> selectAll(String countryID);
}
