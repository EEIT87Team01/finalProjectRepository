package _01.model.city;

import java.util.List;

public interface CityInterface {
	public int insert(CityVO cityVO);
	public int update(CityVO cityVO);
	public int delete(CityPK cityPK);
	public CityVO selectOne(CityPK cityPK);
	public List<CityVO> selectAll();
}
