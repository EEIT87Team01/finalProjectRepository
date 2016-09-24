package iii.runninglife.controller.sporthistorypath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import iii.runninglife.model.sporthistorypath.SportHistoryPathService;

@Controller
@RequestMapping("/sport_history_path")
public class SportHistoryPathController {
	@Autowired
	private SportHistoryPathService sportHistoryPathService;
	
	@RequestMapping(value="/batch_update",method=RequestMethod.POST)
	public ModelAndView BatchUpdate(@RequestParam String memberID,@RequestParam String path){
		sportHistoryPathService.batchUpdateSportHistoryPath(memberID, path);
		
		return null;
	}
}
