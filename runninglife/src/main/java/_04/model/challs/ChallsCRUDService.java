package _04.model.challs;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ChallsCRUDService {

	public static void main(String[] args) {
        
	}
	public int insertService(String challenName,String locationID,double challenDistance,java.sql.Date challenStartTime,java.sql.Date challenEndTime,String comment,String image,String founderID){
		Date d=new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(d);
		IchallDAO dao=new ChallsDAO();
		try {
			String dayChalls=dao.countDateChallenge(dateString);
			ChallsVO addchall=new ChallsVO(dateString+dayChalls,challenName,locationID,challenDistance,challenStartTime,challenEndTime,comment,image,founderID);
			dao.insert(addchall);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteService(String challenID){
		IchallDAO dao=new ChallsDAO();
		try {
			dao.delete(challenID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public ChallsVO searchOneService(String challenID){
		IchallDAO dao=new ChallsDAO();
		try {
			ChallsVO findChall=dao.findByPrimaryKey(challenID);
			return findChall;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<ChallsVO> searchAllService(){
		IchallDAO dao=new ChallsDAO();
		try {
			List<ChallsVO> challList=dao.getAll();
			return challList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
