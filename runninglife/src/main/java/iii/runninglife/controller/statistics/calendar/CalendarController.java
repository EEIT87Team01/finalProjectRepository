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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import iii.runninglife.model.calendar.CalendarVO;
import iii.runninglife.model.sporthistory.SportHistoryService;
import iii.runninglife.model.sporthistory.SportHistoryVO;
import iii.runninglife.model.sporthistorypath.SportHistoryPathVO;

@RestController
@RequestMapping("/calendar")
public class CalendarController{
	@Autowired
	SportHistoryService sportHistoryService;
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public ModelAndView calendar(HttpSession session){
		
		Object memberVO = null;
		
		if((memberVO = session.getAttribute("membersVO")) != null){
//			return new ModelAndView("calendar","memberID",memberVO.getMemberID());
			return new ModelAndView("calendar","memberID","665922cd-6039-4d69-b963-dc1b7b62ec96");//測試用
		}else{
			return new ModelAndView("login",null);
		}
	}
	
	@RequestMapping(value="get_calendar_json_data",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String getCalendarJsonData(HttpServletRequest req){
		
		List<CalendarVO> eventList = new ArrayList<>();
		Iterator<SportHistoryVO> sportHistorys = sportHistoryService.getDataByMemberDurationDate(
				req.getParameter("memberID"),
				Date.valueOf(req.getParameter("start")),
				Date.valueOf(req.getParameter("end"))).iterator();
		 
		SportHistoryVO sportHistoryVO = null;
		String contextPath = req.getContextPath();
		while(sportHistorys.hasNext()){
			CalendarVO event = new CalendarVO();
			sportHistoryVO = sportHistorys.next();
			event.setId("H" + sportHistoryVO.getRecordID());
			event.setStart(sportHistoryVO.getStartDateTime().toString());
			event.setEnd(sportHistoryVO.getEndDateTime().toString());
			event.setTitle("運動紀錄");
			event.setColor("YellowGreen"); 
			event.setUrl(contextPath + "/calendar/sport_history.do?recordID=" + sportHistoryVO.getRecordID());
			 
			eventList.add(event);
		}
		 
		//...挑戰 & 賽事 for database
		
		 //挑戰測試
		 CalendarVO event = new CalendarVO();
		 event.setId("C" + "1");
		 event.setStart("2016-09-14 00:00:00.0");
		 event.setEnd("2016-09-22 23:59:59.999");
		 event.setTitle("挑戰名稱challenName");
		 event.setColor("DeepSkyBlue");
		 event.setUrl(contextPath);
		 
		 eventList.add(event);
		 
		//賽事測試
		 event = new CalendarVO();
		 event.setId("R" + "1");
		 event.setStart("2016-09-15 08:00:00.0");
		 event.setEnd("2016-09-15 10:59:59.999");
		 event.setTitle("賽事名稱");
		 event.setColor("IndianRed");
		 event.setUrl(contextPath);
		 
		 eventList.add(event);
		 
		 
		 
		 return new Gson().toJson(eventList);
	}
	
	@RequestMapping(value="/sport_history",method = RequestMethod.GET)
	public ModelAndView getSportHistoryDetailView(@RequestParam String recordID){
		 
		SportHistoryVO sportHistoryVO = sportHistoryService.getOneSportHistory(recordID);
		Map<String,String> map = new HashMap<>();
		String[] jsonArray;
		
		map.put("startDateTime", formatDateTime(sportHistoryVO.getStartDateTime()));
		map.put("endDateTime", formatDateTime(sportHistoryVO.getEndDateTime()));
		map.put("duration", formatDurationTime(sportHistoryVO.getDuration()));
		map.put("length", sportHistoryVO.getLength().toString() + "km");
		map.put("avgSpeed", sportHistoryVO.getAvgSpeed().toString() + "km/h");
		jsonArray = convert2Json(sportHistoryVO.getSportHistoryPaths()).split("/");
		map.put("paths", jsonArray[0]);
		map.put("center", jsonArray[1]);
		
		return new ModelAndView("sport_history_detail",map);
	}
	
	@RequestMapping(value="/challen",method = RequestMethod.GET)
	public ModelAndView getChallenDetailView(HttpServletRequest req){
		 
		return new ModelAndView();
	}
	
	@RequestMapping(value="/race",method = RequestMethod.GET)
	public ModelAndView getRaceDetailView(HttpServletRequest req){

		return new ModelAndView();
	}
	
	private String formatDateTime(Timestamp dateTime){
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(dateTime);
	}
	
	private String formatDurationTime(String durationTime){
		return new DecimalFormat("#00").format(Double.valueOf(durationTime.substring(0,3))) + 
				":" + durationTime.substring(3,5) + 
				":" + durationTime.substring(5);
	}
	
	private String convert2Json(Set<SportHistoryPathVO> pathVOs){
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
			
			
			//經緯度加總
			pathPoints = pathVO.toString().split("-");
			for(int i = 0;i<pathPoints.length;i++){
				pathPoint = pathPoints[i].split(":");
				centerLat += Double.valueOf(pathPoint[0]);
				centerLng += Double.valueOf(pathPoint[1]);
				totalPointCount++;
			}
		}		
		points.append("]");
		
		//計算所有經緯度中心點
		centerLat = centerLat/totalPointCount;
		centerLng = centerLng/totalPointCount;
		points.append("/");
		points.append("{lat:" + centerLat + ",lng:" + centerLng + "}");
		
		return points.toString();
	}
}
