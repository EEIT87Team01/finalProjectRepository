package _05controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import _05model.clothes.ClothesDAOimpl;
import _05model.contest.ContestDAOimpl;
import _05model.contest.ContestVO;
import _05model.event.EventDAOimpl;
import _05model.runner.RunnerDAOimpl;
import _05model.team.TeamDAOimpl;
@Controller
public class EventController {

	@Autowired
	private ContestDAOimpl contestDAO;
	@Autowired
	private EventDAOimpl eventDAO;
	@Autowired
	private TeamDAOimpl teamDAO;
	@Autowired
	private RunnerDAOimpl runnerDAO;
	@Autowired
	private ClothesDAOimpl clothesDAO;

	
	@RequestMapping("contest")
	public String showEvents(Model model) {
		List<ContestVO>contests =contestDAO.getAll();
		model.addAttribute("contests", contests);
		return "event";
	}
	@RequestMapping("contest/{contestID}")
	public String index(@PathVariable int contestID,Model model) {
		
//		model.addAttribute("events", "Hello,World.");
		return "index";
	}
}
