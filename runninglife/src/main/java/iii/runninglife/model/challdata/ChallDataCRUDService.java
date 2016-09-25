package iii.runninglife.model.challdata;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.model.challs.IchallDAO;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;

@Service
@Transactional
public class ChallDataCRUDService {
	
	@Autowired
	IchallDataDAO dao;
	@Autowired
	IchallDAO challDAO;
	@Autowired
	MembersInterface memberDAO;

	public void insertService(ChallDataPK two_ID,Timestamp finishTime,double processLength,String duration,String status,String isFounder){
			ChallDataVO addchallData=new ChallDataVO(two_ID, finishTime, processLength, duration, status, isFounder);
			dao.insert(addchallData);
	}
	public void updateService(ChallDataPK two_ID,Timestamp finishTime,double processLength,String duration,String isFounder){
		
//		IchallDataDAO dao=new ChallDataDAO(); 
//		List<ChallDataVO> challdata=dao.findByMemberInTime(memberID); 
//		IchallDAO challdao=new ChallsDAO(); 
//		List<ChallDataVO> updateChallData = null ; 
//		for(int i=0;i<=challdata.size();i++){ 
//		if(challdao.findByChallenIDAndDate(challdata.get(i).getChallenID().getChallenID())==1){ 
//		updateChallData.add(challdata.get(i)); 
//		} 
//		} 
//		for(int i=0;i<=updateChallData.size();i++){ 
//		String ChallDataStatus="1"; 
//		double updateProcessLength=processLength+updateChallData.get(i).getProcessLength(); 
//		if(updateChallData.get(i).getChallenID().getChallenDistance()<=updateProcessLength){ 
//		ChallDataStatus="2"; 
//		} 
//		String updateDuration =addDuration(updateChallData.get(i).getDuration(),duration); 
//		ChallData_PK challData_PK=new ChallData_PK(updateChallData.get(i).getChallenID().getChallenID(),memberID) ; 
//		ChallDataVO updatechallData=new ChallDataVO(challData_PK, finishTime, updateProcessLength, updateDuration,ChallDataStatus); 
//		dao.update(updatechallData); 
//		}
		List<ChallDataVO> challdataProcessing = dao.findByMemberProcessing(two_ID.getMemberID());
		List<ChallDataVO> updateChallDatas = null ;
		for(ChallDataVO challDataVO : challdataProcessing){ 
			if(challDataVO.getStatus().equals("1")){ 
				updateChallDatas.add(challDataVO); 
			} 
		} 
		for(ChallDataVO updateChallData : updateChallDatas){ 
			String ChallDataStatus="1"; 
			double updateProcessLength = processLength + updateChallData.getProcessLength(); 
			String updateDuration = addDuration(updateChallData.getDuration(),duration);
			if(updateChallData.getChallDataPK().getChallenID().getChallenDistance()<=updateProcessLength){ 
				ChallDataStatus="2"; 
			} 
		}
		
		for(ChallDataVO updateChallData : updateChallDatas) dao.update(updateChallData);
		
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
	
	public List<ChallDataVO> memberProcessingChallService(MembersVO membersVO){
		List<ChallDataVO> challDataList = null;
		challDataList=dao.findByMemberProcessing(membersVO);
		return challDataList;
	}
	public List<ChallDataVO> memberFinishChallService(MembersVO membersVO){
		List<ChallDataVO> challDataList = null;
		challDataList=dao.findByMemberFinish(membersVO);
		return challDataList;
	}
	public List<ChallDataVO> memberReservedChallService(MembersVO membersVO){
		return dao.findByMemberReserved(membersVO);
	}
	public List<ChallDataVO> findByMemberReceivedRequestService(MembersVO membersVO){
		return dao.findByMemberReceivedRequest(membersVO);
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
