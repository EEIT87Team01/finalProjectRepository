package iii.runninglife.model.challs;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.model.members.MembersVO;

@Service
public class ChallsCRUDService {
	
	@Autowired
	IchallDAO dao;

	public int insertService(String challenName,String locationID,double challenDistance,java.sql.Date challenStartTime,java.sql.Date challenEndTime,String comment,String image,MembersVO founderID){
		Date d=new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(d);
		String dayChalls=dao.countDateChallenge(dateString);
		ChallsVO addchall=new ChallsVO(dateString+dayChalls,challenName,locationID,challenDistance,challenStartTime,challenEndTime,comment,image,founderID);
		System.out.println(addchall.getFounderID().getMemberID());
		dao.insert(addchall);
		return 0;
	}
	public void deleteService(String challenID){
		dao.delete(challenID);
	}
	public ChallsVO searchOneService(String challenID){
		ChallsVO findChall=dao.findByPrimaryKey(challenID);
		return findChall;
	}
	public List<ChallsVO> searchByDateService(){
		List<ChallsVO> findChall=dao.findByDate();
		return findChall;
	}
	public List<ChallsVO> searchByEndDateService(){
		List<ChallsVO> findChall=dao.findByEndDate();
		return findChall;
	}
	public List<ChallsVO> searchByStartDateService(){
		List<ChallsVO> findChall=dao.findByStartDate();
		return findChall;
	}
	public List<ChallsVO> searchAllService(){
		List<ChallsVO> challList=dao.getAll();
		return challList;
	}
}
