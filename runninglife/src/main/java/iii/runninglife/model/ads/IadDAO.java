package iii.runninglife.model.ads;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IadDAO {
	public void insert(AdsVO ad);
	public void update(AdsVO ad);
	public void delete(String adID);
	public AdsVO findByPrimaryKey(String adID);
	public List<AdsVO> getAll();
	public String countDateAd(String adTime);
} // end of class IEmpDAO