package _01.model.country;

import java.util.List;

public interface CountryInterface {
	public int insert(CountryVO countryVO);
	public int update(CountryVO countryVO);
	public int delete(String countryVO);
	public CountryVO selectOne(String countryVO);
	public List<CountryVO> selectAll();
}
