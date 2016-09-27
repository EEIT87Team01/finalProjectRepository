package iii.runninglife.controller.statistics.calendar;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import iii.runninglife.globalservice.CalulateTwoLatLng;
import iii.runninglife.model.calendar.CalendarVO;
import iii.runninglife.model.challdata.ChallDataCRUDService;
import iii.runninglife.model.challdata.ChallDataPK;
import iii.runninglife.model.challdata.ChallDataVO;
import iii.runninglife.model.challs.ChallsCRUDService;
import iii.runninglife.model.challs.ChallsVO;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;
import iii.runninglife.model.runner.RunnerService;
import iii.runninglife.model.runner.RunnerVO;
import iii.runninglife.model.sporthistory.SportHistoryService;
import iii.runninglife.model.sporthistory.SportHistoryVO;
import iii.runninglife.model.sporthistorypath.PathVO;
import iii.runninglife.model.sporthistorypath.SportHistoryPathService;
import iii.runninglife.model.sporthistorypath.SportHistoryPathVO;

@RestController
@RequestMapping("/calendar")
public class CalendarController{
	@Autowired
	SportHistoryService sportHistoryService;
	@Autowired
	SportHistoryPathService sportHistoryPathService;
	@Autowired
	ChallDataCRUDService challDataCRUDService;
	@Autowired
	RunnerService runnerService;
	@Autowired
	MembersInterface memberDAO;
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public ModelAndView calendar(HttpSession session){
		
		MembersVO memberVO = null;
		
		if((memberVO = (MembersVO) session.getAttribute("membersVO")) != null){
			return new ModelAndView("/calendar/calendar","memberVO",memberVO);
		}else{
			return new ModelAndView("redirect:/",null);
		}
	}
	
	@RequestMapping(value="get_calendar_json_data",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String getCalendarJsonData(@RequestParam String memberID,@RequestParam String start,@RequestParam String end){
		
		List<CalendarVO> eventList = new ArrayList<>();
		Date startDate = Date.valueOf(start);
		Date endDate = Date.valueOf(end);
		
		Iterator<SportHistoryVO> sportHistorys = sportHistoryService
							.getDataByMemberDurationDate(memberID,startDate,endDate)
							.iterator();
		
		SportHistoryVO sportHistoryVO = null;
		while(sportHistorys.hasNext()){
			CalendarVO event = new CalendarVO();
			sportHistoryVO = sportHistorys.next();
			event.setId("H" + sportHistoryVO.getRecordID());
			event.setStart(sportHistoryVO.getStartDateTime().toString());
			event.setEnd(sportHistoryVO.getEndDateTime().toString());
			event.setTitle("運動紀錄");
			event.setColor("YellowGreen"); 
			event.setUrl( "calendar/sport_history.do?recordID=" + sportHistoryVO.getRecordID());
			 
			eventList.add(event);
		}
		
		Iterator<ChallDataVO> challDatas = challDataCRUDService
							.memberTimeChallService(memberID, startDate, endDate)
							.iterator();
		
		ChallDataVO challDataVO = null;
		while(challDatas.hasNext()){
			CalendarVO event = new CalendarVO();
			challDataVO = challDatas.next();
			event.setId("C" + challDataVO.getChallDataPK().getChallenID().getChallenID());
			event.setStart(challDataVO.getChallDataPK().getChallenID().getChallenStartTime().toString());
			event.setEnd(challDataVO.getChallDataPK().getChallenID().getChallenEndTime().toString());
			event.setTitle(challDataVO.getChallDataPK().getChallenID().getChallenName());
			event.setColor("DeepSkyBlue"); 
			event.setUrl("calendar/challen.do?challenID=" + challDataVO.getChallDataPK().getChallenID().getChallenID());
			 
			eventList.add(event);
		}
		
		Iterator<RunnerVO> races = runnerService
				.getMyContestByDate(memberID, startDate, endDate)
				.iterator();
		
		RunnerVO runnerVO = null;
		while(races.hasNext()){
			CalendarVO event = new CalendarVO();
			runnerVO = races.next();
			event.setId("R" + runnerVO.getPk().getContestID());
			event.setStart(runnerVO.getContest().getStartDate().toString());
			event.setEnd(runnerVO.getContest().getStartDate().toString());
			event.setTitle(runnerVO.getContest().getContestName());
			event.setColor("IndianRed"); 
			event.setUrl("calendar/race.do?contestID=" + runnerVO.getPk().getContestID());
			
			eventList.add(event);
		}
  
		return new Gson().toJson(eventList);
	}
	
	@RequestMapping(value="/sport_history",method = RequestMethod.GET)
	public ModelAndView getSportHistoryDetailView(@RequestParam String recordID){
		 
		SportHistoryVO sportHistoryVO = sportHistoryService.getOneSportHistory(recordID);
		List<SportHistoryPathVO> pathList = sportHistoryPathService.getPathsByRecordID(recordID);
		Map<String,String> map = new HashMap<>();
		String[] jsonArray;
		
		MembersVO membersVO = memberDAO.selectOne(sportHistoryVO.getMemberID());
		map.put("memberFirstName", membersVO.getFirstName());
		map.put("startDateTime", formatDateTime(sportHistoryVO.getStartDateTime()));
		map.put("endDateTime", formatDateTime(sportHistoryVO.getEndDateTime()));
		map.put("duration", formatDurationTime(sportHistoryVO.getDuration()));
		map.put("length", sportHistoryVO.getLength().toString() + "km");
		map.put("avgSpeed", sportHistoryVO.getAvgSpeed().toString() + "km/h");
		jsonArray = convert2Json(pathList).split("/");
		map.put("paths", jsonArray[0]);
		map.put("center", jsonArray[1]);
		map.put("Zoom", getMapZoom(pathList).toString());
		
		return new ModelAndView("calendar/sport_history_detail",map);
	}
	
	@RequestMapping(value="/challen",method = RequestMethod.GET)
	public ModelAndView getChallenDetailView(@RequestParam String challenID){
		 		
		return new ModelAndView("redirect:/challenge/detail/" + challenID + ".do");
	}
	
	@RequestMapping(value="/race",method = RequestMethod.GET)
	public ModelAndView getRaceDetailView(@RequestParam String contestID){

		return new ModelAndView("redirect:/contest/" + contestID + ".do");
	}
	
	private String formatDateTime(Timestamp dateTime){
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(dateTime);
	}
	
	private String formatDurationTime(String durationTime){
		return new DecimalFormat("#00").format(Double.valueOf(durationTime.substring(0,3))) + 
				":" + durationTime.substring(3,5) + 
				":" + durationTime.substring(5);
	}
	
	private String convert2Json(List<SportHistoryPathVO> pathVOs){
		StringBuilder points = new StringBuilder();
		Double centerLat = 0.0;
		Double centerLng = 0.0;
		Integer totalPointCount = 0;
		String[] pathPoints;
		String[] pathPoint;
		
		points.append("[");
		for(SportHistoryPathVO pathVO:pathVOs){
			if(points.length()>1)
				points.append(",");
			points.append(pathVO.toJson());
			
			//加總經緯度
			pathPoints = pathVO.toString().split("-");
			for(int i = 0;i<pathPoints.length;i++){
				pathPoint = pathPoints[i].split(":");
				centerLat += Double.valueOf(pathPoint[0]);
				centerLng += Double.valueOf(pathPoint[1]);
				totalPointCount++;
			}
		}		
		points.append("]");
		
		//計算經緯度中心點
		centerLat = centerLat/totalPointCount;
		centerLng = centerLng/totalPointCount;
		points.append("/");
		points.append("{lat:" + centerLat + ",lng:" + centerLng + "}");
		
		return points.toString();
	}
	
	private Integer getMapZoom(List<SportHistoryPathVO> pathList){
		
		Double maxLength = getLatLngMaxLength(pathList);
		int mapZoom = 20;
		
		if(maxLength<=0.5){
			mapZoom=18;
		}else if(maxLength<=2){
			mapZoom=16;
		}else{
			mapZoom=14; 
		}
		
		return mapZoom;
	}
	
	private Double getLatLngMaxLength(List<SportHistoryPathVO> pathList){
		Double maxLength = 0.0;
		Double tempLength = 0.0;
		List<PathVO> pathVOList = new ArrayList<>();
		
		for(SportHistoryPathVO sportHistoryPathVO:pathList){
			pathVOList.addAll(new Gson().fromJson(sportHistoryPathVO.getPath(), new TypeToken<List<PathVO>>(){}.getType()));	
		}
		
		for(int i=0;i<pathVOList.size();i++){
			for(int j=i+1;j<pathVOList.size();j++){
				tempLength = CalulateTwoLatLng.getDistance(
									pathVOList.get(i).getLat(), 
									pathVOList.get(i).getLng(),
									pathVOList.get(j).getLat(), 
									pathVOList.get(j).getLng());
				if(tempLength > maxLength){
					maxLength = tempLength;
				}
			}
		}
		return maxLength;
	}
}
