package _05controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import _05model.member.MemberVO;
import _05model.runner.RunnerDAOimpl;
import _05model.team.TeamDAOimpl;
import _05model.team.TeamVO;
import _05service.email.MailService;
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
	@Autowired
	private MailService mailService;

	
	@RequestMapping("contest")
	public String showEvents(Model model) {
		List<ContestVO>contests =contestDAO.getAll();
		model.addAttribute("contests", contests);
		
		return "contest";
	}
	@RequestMapping("contest/{contestID}")
	public String index(@PathVariable int contestID,Model model) {
		List<TeamVO>teams =teamDAO.getTeamById(contestID);
		ContestVO contest = contestDAO.findByPrimaryKey(contestID);
		//修正時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		String begin = sdf.format(contest.getRegistrationBegin());
		String end = sdf.format(contest.getRegistrationEnd());
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 (E)");
		String start = sdf2.format(contest.getStartDate());
		
		
		model.addAttribute("start", start);
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
		model.addAttribute("teams", teams);
		model.addAttribute("contest", contest);
		return "detail";
	}
	
	@RequestMapping("email")
	public String emailtest(Model model) {
		MemberVO member = new MemberVO();
		member.setEmail("artashur@gmail.com");
		member.setLastName("Max");
		member.setMemberID("Maxcool#3433");
		mailService.sendEmail(member);
		model.addAttribute("A",member);
		return "/../../index";
	}
	
//	@ModelAttribute("contests")
//	public List<ContestVO> getContests(){
//		List<ContestVO>contests =contestDAO.getAll();		
//		
//		return contests;
//	}
}
