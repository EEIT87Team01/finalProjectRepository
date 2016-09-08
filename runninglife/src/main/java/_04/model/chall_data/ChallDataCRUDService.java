package _04.model.chall_data;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ChallDataCRUDService {

	public static void main(String[] args) {
        
	}
	public int insertService(Two_ID two_ID,Timestamp finishTime,double processLength,double duration){
		IchallDataDAO dao=new ChallDataDAO();
		try {
			ChallDataVO addchallData=new ChallDataVO(two_ID, finishTime, processLength, duration);
			dao.insert(addchallData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int updateService(Two_ID two_ID,Timestamp finishTime,double processLength,double duration){
		IchallDataDAO dao=new ChallDataDAO();
		try {
			ChallDataVO updatechallData=new ChallDataVO(two_ID, finishTime, processLength, duration);
			dao.update(updatechallData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteService(Two_ID two_ID){
		IchallDataDAO dao=new ChallDataDAO();
		try {
			dao.delete(two_ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public ChallDataVO searchOneService(Two_ID two_ID){
		ChallDataVO findChallData=null;
		IchallDataDAO dao=new ChallDataDAO();
		try {
			findChallData=dao.findByPrimaryKey(two_ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return findChallData;
	}
	public List<ChallDataVO> searchAllService(){
		List<ChallDataVO> challDataList = null;
		IchallDataDAO dao=new ChallDataDAO();
		try {
			challDataList=dao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return challDataList;
	}
	public Two_ID setTwoIDService(String challenID,String memberID){
		return new Two_ID(challenID,memberID);
	}
	public List<ChallDataVO> challProgressService(String challenID){
		List<ChallDataVO> challDataList = null;
		IchallDataDAO dao=new ChallDataDAO();
		try {
			challDataList=dao.findByChall(challenID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return challDataList;
	}
	public List<ChallDataVO> memberChallProgressService(String memberID){
		List<ChallDataVO> challDataList = null;
		IchallDataDAO dao=new ChallDataDAO();
		try {
			challDataList=dao.findByMember(memberID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return challDataList;
	}
}
