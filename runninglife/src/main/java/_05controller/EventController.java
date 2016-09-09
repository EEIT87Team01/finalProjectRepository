package _05controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import _05model.clothes.ClothesDAOimpl;
import _05model.clothes.ClothesVO;
import _05model.contest.ContestDAOimpl;
import _05model.contest.ContestVO;
import _05model.event.EventDAOimpl;
import _05model.event.EventVO;
import _05model.member.MemberVO;
import _05model.runner.RunnerDAOimpl;
import _05model.runner.RunnerVO;
import _05model.team.TeamDAOimpl;
import _05model.team.TeamVO;
import _05service.ContestService;
import _05service.email.MailService;
import _05validator.EventValidator;
import _05validator.FileValidator;

@Controller
@SessionAttributes("member")
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
	@Autowired
	private ContestFormValidator contestFormValidator;
	@Autowired
	private FileValidator fileValidator;
	@Autowired
	private EventValidator eventValidator;
	@Autowired
	private ContestService contestService;

	// show all contests
	@RequestMapping(value = "contest", method = RequestMethod.GET)
	public String showAllContests(Model model) {
		List<ContestVO> contests = contestDAO.getAll();
		model.addAttribute("contests", contests);
		return "contest";
	}

	// show contest
	@RequestMapping(value = "/contest/{contestID}", method = RequestMethod.GET)
	public String showContest(@PathVariable int contestID, Model model) {
		List<TeamVO> teams = teamDAO.getTeamById(contestID);
		List<EventVO> events = eventDAO.getEventById(contestID);
		ContestVO contest = contestDAO.findByPrimaryKey(contestID);
		List<ClothesVO> clothes = clothesDAO.getAll();
		// 修正時間
		System.out.println("a:"+contest.getRegistrationBegin());System.out.println("b:"+contest.getRegistrationEnd());System.out.println("c:"+contest.getStartDate());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
		String begin = sdf.format(contest.getRegistrationBegin());
		String end = sdf.format(contest.getRegistrationEnd());
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 (E)");
		String start = sdf2.format(contest.getStartDate());
		EventVO event = new EventVO();
		long timer = contest.getStartDate().getTime();
		model.addAttribute("timer",timer);
		model.addAttribute("event", event);
		model.addAttribute("start", start);
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
		model.addAttribute("events", events);
		model.addAttribute("teams", teams);
		model.addAttribute("contest", contest);
		model.addAttribute("clothes", clothes);
		return "detail";
	}


	// show contest form
	@RequestMapping(value = "/contest/edit", method = RequestMethod.GET)
	public String showUpdateContestForm(Model model, HttpServletRequest req) {
		ContestVO contest = new ContestVO();
		try {
			Integer id = Integer.valueOf(req.getParameter("id"));
			System.out.println("修改賽事:"+id);
			contest = contestDAO.findByPrimaryKey(id);
		} catch (Exception e) {
			System.out.println("新增賽事");
		}
		model.addAttribute("contest", contest);
		return "contestform";
	}

	// 錯誤訊息
	@InitBinder("contest")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(contestFormValidator);
	}

	@InitBinder("fileUpload")
	protected void initBinderFile(WebDataBinder binder) {
		binder.setValidator(fileValidator);
	}

	private String path = "c:/run/";

	/// add.update contest
	@RequestMapping(value = "/contest/edit", method = RequestMethod.POST)
	public String SaveUser(@ModelAttribute("contest") @Validated ContestVO contest, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes, @RequestParam @Validated CommonsMultipartFile[] fileUpload) {
		if (result.hasErrors()) {
			return "contestform";
		} else {
			// 新增表單
			contestService.createContest(contest);
			contestService.photo(fileUpload, contest);

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			// POST/REDIRECT/GET
			return "redirect:/contest/" + contest.getContestID();
		}
	}

	// delete contest
	@RequestMapping(value = "contest/{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		MemberVO memeber = (MemberVO) request.getSession().getAttribute("member");
		// if(memeber!=null){
		contestDAO.delete(id);
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");
		// }

		return "redirect:/contest";
	}

	@InitBinder("eventVO")
	protected void initBinderEvent(WebDataBinder binder) {
		binder.setValidator(eventValidator);
	}

	// add event
	@RequestMapping(value = "/{id}/event/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=UTF-8")
	public @ResponseBody EventVO addEvent(@PathVariable("id") Integer id, @RequestBody @Validated EventVO eventVO) {

		eventVO.setContestID(id);
		eventDAO.insert(eventVO);
		System.out.println("ajxa------------------------------------");
		return eventVO;
	}

	// delete event
	@RequestMapping(value = "/event/{id}/delete", method = RequestMethod.POST, produces = "text/html; charset=UTF-8") // produces
																														// =
																														// "text/html;
																														// charset=UTF-8"
	public @ResponseBody String deleteEvent(HttpServletResponse response, @PathVariable("id") Integer id) {

		eventDAO.delete(id);
		System.out.println("刪除eventID=" + id);
		// response.setCharacterEncoding("UTF-8");
		return "刪除成功";
	}

	// add team
	@RequestMapping(value = "{id}/team/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=UTF-8")
	public @ResponseBody TeamVO addTeam(@PathVariable("id") Integer id, @RequestBody TeamVO teamVO,
			HttpServletResponse res) {

		teamVO.setContestID(id);
		teamDAO.insert(teamVO);
		System.out.println("ajxa------------------------------------");
		return teamVO;
	}

	// delete team
	@RequestMapping(value = "/team/delete", method = RequestMethod.POST, produces = "text/html; charset=UTF-8") // produces
																												// =
																												// "text/html;
																												// charset=UTF-8"
	public @ResponseBody String deleteTeam(HttpServletRequest req, @RequestParam Integer id) {
		teamDAO.delete(id);
		System.out.println("刪除teamID=" + id);
		return "刪除成功";
	}

	private String saveDirectory = "c:/run/upload/";

	@RequestMapping(value = "contest/{id}/upload", method = RequestMethod.POST)
	public String ContestPhotoUpload(@RequestParam CommonsMultipartFile[] fileUpload, @PathVariable("id") int id)
			throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				if (!aFile.getOriginalFilename().equals("")) {
					// aFile.transferTo(new File(saveDirectory +
					// aFile.getOriginalFilename()));
					File photo = new File(saveDirectory + id + ".jpg");
					if (!photo.exists()) {
						photo.mkdirs();
					}
					aFile.transferTo(photo);
					ContestVO contest = contestDAO.findByPrimaryKey(id);
					contest.setContestPhotoPath(id + ".jpg");
					contestDAO.update(contest);
				}
			}
		}
		return "redirect:/contest";
	}

	// apply
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String ContestApply(@ModelAttribute RunnerVO runner, @SessionAttribute MemberVO member, Model model,HttpServletRequest req) {
		Integer id = runner.getPk().getContestID();
		
		int age =20;//從member取出年齡
//		age =member.getAge();
		TeamDAOimpl teamDAO = new TeamDAOimpl();
		List <TeamVO> list =teamDAO.getTeamById(id);
		TeamVO yourTeam=list.get(list.size()-1);//預設最年輕組
		for(TeamVO team :list){
			System.out.println(team);
			if(team.getAgeRange()<=age &&  team.getAgeRange()+9 > age){
				age  = team.getAgeRange();
				yourTeam = team;
				System.out.println("被分派到組別:"+team.getTeamName());
				System.out.println("組別範圍:"+team.getAgeRange()+"~"+(team.getAgeRange()+9));
			}
		}
		runner.setTeamID(yourTeam.getTeamID());
		
		
		try {
			String status = runnerDAO.insert(runner);
			ContestVO contest = contestDAO.findByPrimaryKey(runner.getPk().getContestID());
//			mailService.sendApplyEmail(member, contest);
			System.out.println(status);
		} catch (Exception ex) {
			System.out.println("-----------------------------------------------");
		}
		return "redirect:/contest/" + id;
	}

	@RequestMapping(value = "/score", method = RequestMethod.GET)
	public String showScore(Model model) {
		return "score";
	}

	@RequestMapping("email")
	public String emailtest(Model model, @SessionAttribute("member") MemberVO member) {
		mailService.sendEmail(member);
		return "/../../index";
	}
	@ModelAttribute("member")
	public MemberVO login() {
		MemberVO member = new MemberVO();
		member.setEmail("artashur@gmail.com");
		member.setLastName("Arthur");
		member.setMemberID("arthur");
		return member;
	}
	// @ModelAttribute("contests")
	// public List<ContestVO> getContests(){
	// List<ContestVO>contests =contestDAO.getAll();
	//
	// return contests;
	// }
}
