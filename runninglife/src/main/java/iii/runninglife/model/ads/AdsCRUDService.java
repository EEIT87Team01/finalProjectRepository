package iii.runninglife.model.ads;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdsCRUDService {
	
	@Autowired
	IadDAO dao;

	public void insertService(String adName,String division,String link,java.sql.Date adStartTime,java.sql.Date adEndTime,int priority,String image){
		Date d=new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(d);
		String dayAds=dao.countDateAd(dateString);
		AdsVO addad=new AdsVO(dateString+dayAds,adName,division,link,adStartTime,adEndTime,priority,image);
		dao.insert(addad);
	}
	public void updateService(String adID,String adName,String division,String link,java.sql.Date adStartTime,java.sql.Date adEndTime,int priority,String image){
		AdsVO updatead=new AdsVO(adID,adName,division,link,adStartTime,adEndTime,priority,image);
		dao.update(updatead);
	}
	public void deleteService(String adID){
		dao.delete(adID);
	}
	public AdsVO searchOneService(String adID){
		AdsVO findAd=dao.findByPrimaryKey(adID);
		return findAd;
	}
	public List<AdsVO> searchAllService(){
		List<AdsVO> adList=dao.getAll();
		return adList;
	}
	public List<AdsVO> searchDisplayService(){
		List<AdsVO> adList=dao.getDisplay();
		return adList;
	}
}
