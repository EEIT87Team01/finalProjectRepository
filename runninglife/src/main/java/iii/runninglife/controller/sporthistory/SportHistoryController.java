package iii.runninglife.controller.sporthistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import iii.runninglife.model.sporthistory.SportHistoryService;

@Controller
@RequestMapping("/sport_history")
public class SportHistoryController {
	
	@Autowired
	private SportHistoryService sportHistoryService;
	
	//測試用
	@RequestMapping("")
	public ModelAndView sportHistory(){
		return new ModelAndView("sport_history","message","hello bowei");
	}

	@RequestMapping(value="/start",method=RequestMethod.POST)
	public ModelAndView startRunning(@RequestParam String memberID){
		
		sportHistoryService.startSportHistory(memberID);
		return null;
	}
	
	@RequestMapping(value="/end",method=RequestMethod.POST)
	public ModelAndView endRunning(@RequestParam String memberID){
		sportHistoryService.endSportHistory(memberID);
		return null;
	}
}
