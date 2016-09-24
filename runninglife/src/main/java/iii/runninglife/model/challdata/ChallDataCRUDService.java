package iii.runninglife.model.challdata;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.model.challs.IchallDAO;
import iii.runninglife.model.members.MembersInterface;

@Service
@Transactional
public class ChallDataCRUDService {
	
	@Autowired
	IchallDataDAO dao;
	@Autowired
	IchallDAO challDAO;
	@Autowired
	MembersInterface memberDAO;

	public void insertService(ChallDataPK two_ID,Timestamp finishTime,double processLength,String duration){
			ChallDataVO addchallData=new ChallDataVO(two_ID, finishTime, processLength, duration);
			dao.insert(addchallData);
	}
	public void updateService(ChallDataPK two_ID,Timestamp finishTime,double processLength,String duration){
		ChallDataVO challdata=searchOneService(two_ID);
		double updateProcessLength=processLength+challdata.getProcessLength();
		String updateDuration =addDuration(challdata.getDuration(),duration);
			ChallDataVO updatechallData=new ChallDataVO(two_ID, finishTime, updateProcessLength, updateDuration);
			dao.update(updatechallData);
	}
	public void deleteService(ChallDataPK two_ID){
			dao.delete(two_ID);
	}
	public ChallDataVO searchOneService(ChallDataPK two_ID){
		ChallDataVO findChallData=null;
			findChallData=dao.findByPrimaryKey(two_ID);
		return findChallData;
	}
	public void checkService(ChallDataPK two_ID){
		dao.findByPrimaryKey(two_ID);
	}
	public List<ChallDataVO> searchAllService(){
		List<ChallDataVO> challDataList = null;
			challDataList=dao.getAll();
		return challDataList;
	}
	public ChallDataPK setTwoIDService(String challenID,String memberID){
		return new ChallDataPK(challDAO.findByPrimaryKey(challenID),memberDAO.selectOne(memberID));
	}
	public List<ChallDataVO> challProgressService(String challenID){
		List<ChallDataVO> challDataList = null;
			challDataList=dao.findByChall(challenID);
		return challDataList;
	}
	public List<ChallDataVO> memberChallProgressService(String memberID){
		List<ChallDataVO> challDataList = null;
			challDataList=dao.findByMember(memberID);
		return challDataList;
	}
	public List<ChallDataVO> memberTimeChallService(String memberID,java.sql.Date startTime,java.sql.Date endTime){
		List<ChallDataVO> challDataList = null;
			challDataList=dao.findByMemberAndTime(memberID,startTime,endTime);
		return challDataList;
	}
	
	public List<ChallDataVO> memberProcessingChallService(String memberID){
		List<ChallDataVO> challDataList = null;
		challDataList=dao.findByMemberProcessing(memberDAO.selectOne(memberID));
		return challDataList;
	}
	public List<ChallDataVO> memberFinishChallService(String memberID){
		List<ChallDataVO> challDataList = null;
		challDataList=dao.findByMemberFinish(memberDAO.selectOne(memberID));
		return challDataList;
	}
	
	
	
	private String addDuration(String oldtime,String addtime){
		int oldh=Integer.valueOf(oldtime.substring(0,3));
		int oldm=Integer.valueOf(oldtime.substring(3,5));
		int olds=Integer.valueOf(oldtime.substring(5));
		int addh=Integer.valueOf(addtime.substring(0,3));
		int addm=Integer.valueOf(addtime.substring(3,5));
		int adds=Integer.valueOf(addtime.substring(5));
		int newh,newm,news;
		if((olds+adds)>=60){
			news=(olds+adds)-60;
			if((oldm+addm+1)>=60){
				newm=(oldm+addm)+1-60;
				newh=(oldh+addh)+1;
			}else{
				newm=(oldm+addm)+1;
				newh=(oldh+addh);
			}
		}else{
			news=(olds+adds);
			if((oldm+addm)>=60){
				newm=(oldm+addm)-60;
				newh=(oldh+addh)+1;
			}else{
				newm=(oldm+addm);
				newh=(oldh+addh);
			}
		}
		String newsString=String.format("%02d",news);
		String newmString=String.format("%02d",newm);
		String newhString=String.format("%03d",newh);
		return (newhString+newmString+newsString);
	}
}
