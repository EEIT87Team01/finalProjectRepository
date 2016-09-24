package iii.runninglife.model.sporthistory;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.globalservice.CalulateTwoLatLng;
import iii.runninglife.globalservice.ConvertMilliseconds2Hours;
import iii.runninglife.globalservice.StoredProcedure;
import iii.runninglife.model.sporthistorypath.SportHistoryPathVO;

@Service
@Transactional
public class SportHistoryService {
	
	@Autowired
	private SportHistoryDAO_interface dao;
	
	@Autowired
	StoredProcedure storedProcedure;

	public void startSportHistory(String memberID) {

		if(dao.getMemberCurrentRecordID(memberID)==null){
			
			SportHistoryVO sportHistoryVO = new SportHistoryVO();
			sportHistoryVO.setRecordID(storedProcedure.getRecordID());
			sportHistoryVO.setMemberID(memberID);
			sportHistoryVO.setStartDateTime(new Timestamp(System.currentTimeMillis()));
			sportHistoryVO.setEndDateTime(null);
			sportHistoryVO.setDuration(null);
			sportHistoryVO.setAvgSpeed(null);
			sportHistoryVO.setLength(null);
			sportHistoryVO.setLocationID(null);
			
			dao.insert(sportHistoryVO);	
		}
	}

	public void endSportHistory(String memberID) {
		
		String currentRecordID = null;
		
		if((currentRecordID = dao.getMemberCurrentRecordID(memberID))!=null){
			
			SportHistoryVO sportHistoryVO = dao.findByPrimaryKey(currentRecordID);
			sportHistoryVO.setEndDateTime(new Timestamp(System.currentTimeMillis()));
			
			Long durationMTime = sportHistoryVO.getEndDateTime().getTime() - sportHistoryVO.getStartDateTime().getTime();
			durationMTime = (durationMTime+500)/1000*1000;//四捨五入ms
			sportHistoryVO.setDuration(formatDurationMillisTime(durationMTime));
			sportHistoryVO.setLength(computeTotalLength(sportHistoryVO.getSportHistoryPaths()));
			sportHistoryVO.setAvgSpeed(computeAvgSpeed(sportHistoryVO.getLength(),durationMTime));
			
			dao.update(sportHistoryVO);
		}
	}

	public void deleteSportHistory(String recordID) {
		dao.delete(recordID);
	}

	public SportHistoryVO getOneSportHistory(String recordID) {
		return dao.findByPrimaryKey(recordID);
	}

	public List<SportHistoryVO> getAll() {
		return dao.getAll();
	}
	
	public List<SportHistoryVO> getDataByMember(String memberID) {
		return dao.getDataByMember(memberID);
	}

	public List<SportHistoryVO> getDataByMemberDate(String memberID,
														Date date) {
		return dao.getDataByMemberDate(memberID, date);
	}

	public List<SportHistoryVO> getDataByMemberDurationDate(String memberID, 
																Date startDate,
																Date endDate) {
		return dao.getDataByMemberDurationDate(memberID, startDate, endDate);
	}

	public Set<SportHistoryPathVO> getPathsByRecordID(String recordID) {
		return dao.getPathsByRecordID(recordID);
	}
	
	public String getMemberCurrentRecordID(String memberID){
		return dao.getMemberCurrentRecordID(memberID);
	}
	
	private String formatDurationMillisTime(long durationMTime){
		//hhhmmss
		return String.format("%03d%02d%02d", TimeUnit.MILLISECONDS.toHours(durationMTime),
				TimeUnit.MILLISECONDS.toMinutes(durationMTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(durationMTime)),
				TimeUnit.MILLISECONDS.toSeconds(durationMTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(durationMTime)));		
	}
	
	private Double computeTotalLength(Set<SportHistoryPathVO> sportHistoryPathVOs){
		Double currentLat = null;
		Double currentLng = null;
		Double nextLat = null;
		Double nextLng = null;
		String pathPoints[];
		String pathPoint[];
		Double totalLength = 0.0;
		
		for(SportHistoryPathVO sportHistoryPathVO:sportHistoryPathVOs){
			pathPoints = sportHistoryPathVO.toString().split("-");
			for(int i = 0;i<pathPoints.length;i++){
				pathPoint = pathPoints[i].split(":");
				nextLat = Double.valueOf(pathPoint[0]);
				nextLng = Double.valueOf(pathPoint[1]);
				if(currentLat != null && currentLng != null){
					totalLength += CalulateTwoLatLng.getDistance(currentLat, currentLng, nextLat, nextLng);					
				}
				currentLat = nextLat;
				currentLng = nextLng;
			}
		}
		return mathRound(totalLength);
	}
	
	private Double computeAvgSpeed(Double length,long durationMTime){
		return Double.valueOf(mathRound(length/ConvertMilliseconds2Hours.getHours(durationMTime)));
	}
	
	private Double mathRound(double value){
		DecimalFormat df = new DecimalFormat("#.##");
		
		return Double.valueOf(df.format(value));
	}
}
