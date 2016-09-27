package iii.runninglife.model.challs;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.model.challdata.IchallDataDAO;
import iii.runninglife.model.members.MembersVO;

@Service
public class ChallsCRUDService {
	
	@Autowired
	IchallDAO challengeDAO;
	@Autowired
	IchallDataDAO challengeDataDAO;

	public ChallsVO insertService(String challenName,String locationID,double challenDistance,java.sql.Date challenStartTime,java.sql.Date challenEndTime,String comment,String image,MembersVO founderID){
		Date d=new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(d);
		String dayChalls=challengeDAO.countDateChallenge(dateString);
		ChallsVO addchall=new ChallsVO(dateString+dayChalls,challenName,locationID,challenDistance,challenStartTime,challenEndTime,comment,image,founderID);
		challengeDAO.insert(addchall);
		
		return challengeDAO.findByPrimaryKey(dateString+dayChalls);
	}
	public void deleteService(String challenID){
		challengeDAO.delete(challenID);
	}
	public ChallsVO searchOneService(String challenID){
		ChallsVO findChall=challengeDAO.findByPrimaryKey(challenID);
		return findChall;
	}
	public List<ChallsVO> searchByDateService(){
		List<ChallsVO> findChall=challengeDAO.findByDate();
		return findChall;
	}
	public List<ChallsVO> searchByEndDateService(){
		List<ChallsVO> findChall=challengeDAO.findByEndDate();
		return findChall;
	}
	public List<ChallsVO> searchByStartDateService(){
		List<ChallsVO> findChall=challengeDAO.findByStartDate();
		return findChall;
	}
	public List<ChallsVO> searchAllService(){
		List<ChallsVO> challList=challengeDAO.getAll();
		return challList;
	}
	public List<ChallsVO> findByFounderID(MembersVO founderID){
		return challengeDAO.findByFounderID(founderID);
	}
}
