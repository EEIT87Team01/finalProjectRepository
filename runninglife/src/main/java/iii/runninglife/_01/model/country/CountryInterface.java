package iii.runninglife._01.model.country;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CountryInterface {
	public void insert(CountryVO countryVO);
	public void update(CountryVO countryVO);
	public void delete(String countryVO);
	public CountryVO selectOne(String countryVO);
	public List<CountryVO> selectAll();
}
