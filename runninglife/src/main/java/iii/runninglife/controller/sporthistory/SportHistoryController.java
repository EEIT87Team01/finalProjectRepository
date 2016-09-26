package iii.runninglife.controller.sporthistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import iii.runninglife.model.challdata.ChallDataCRUDService;
import iii.runninglife.model.sporthistory.SportHistoryService;
import iii.runninglife.model.sporthistory.SportHistoryVO;
import iii.runninglife.model.sporthistorypath.SportHistoryPathService;

@Controller
@RequestMapping("/sport_history")
public class SportHistoryController {
	
	@Autowired
	private SportHistoryService sportHistoryService;
	@Autowired
	private SportHistoryPathService sportHistoryPathService;
	@Autowired
	private ChallDataCRUDService challDataCRUDService;
	
	//測試用
	@RequestMapping("")
	public ModelAndView sportHistory(){
		return new ModelAndView("sport_history","message","hello bowei");
	}

	@RequestMapping(value="/start",method=RequestMethod.POST)
	public void startRunning(@RequestParam String memberID){
		
		sportHistoryService.startSportHistory(memberID);
	}
	
	@RequestMapping(value="/end",method=RequestMethod.POST)
	public void endRunning(@RequestParam String memberID,@RequestParam String path){
		if(!path.equals("[]")){
			sportHistoryPathService.batchUpdateSportHistoryPath(memberID, path);
			SportHistoryVO sportHistoryVO = sportHistoryService.endSportHistory(memberID);
			challDataCRUDService.updateService(sportHistoryVO.getMemberID(), sportHistoryVO.getEndDateTime(), sportHistoryVO.getLength(), sportHistoryVO.getDuration());
		}else{
			String recordID = sportHistoryService.getMemberCurrentRecordID(memberID);
			if(recordID!= null){
				sportHistoryService.deleteSportHistory(recordID);
			}
		}
	}
}
