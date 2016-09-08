package _04.model.ads;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AdCRUDService {

	public static void main(String[] args) {
        
	}
	public int insertService(String adName,String division,String link,java.sql.Date adStartTime,java.sql.Date adEndTime,int priority,String image){
		Date d=new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(d);
		IadDAO dao=new AdDAO();
		try {
			String dayAds=dao.countDateAd(dateString);
			AdVO addad=new AdVO(dateString+dayAds,adName,division,link,adStartTime,adEndTime,priority,image);
			dao.insert(addad);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int updateService(String adID,String adName,String division,String link,java.sql.Date adStartTime,java.sql.Date adEndTime,int priority,String image){
		IadDAO dao=new AdDAO();
		try {
			AdVO updatead=new AdVO(adID,adName,division,link,adStartTime,adEndTime,priority,image);
			dao.update(updatead);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteService(String adID){
		IadDAO dao=new AdDAO();
		try {
			dao.delete(adID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public AdVO searchOneService(String adID){
		IadDAO dao=new AdDAO();
		try {
			AdVO findAd=dao.findByPrimaryKey(adID);
			return findAd;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<AdVO> searchAllService(){
		IadDAO dao=new AdDAO();
		try {
			List<AdVO> adList=dao.getAll();
			return adList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
