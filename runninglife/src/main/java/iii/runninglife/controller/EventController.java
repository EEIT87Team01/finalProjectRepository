package iii.runninglife.controller;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

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

import iii.runninglife.controller.email.MailService;
import iii.runninglife.controller.validator.EventValidator;
import iii.runninglife.controller.validator.FileValidator;
import iii.runninglife.model.clothes.ClothesDAO;
import iii.runninglife.model.clothes.ClothesDAOimpl;
import iii.runninglife.model.clothes.ClothesVO;
import iii.runninglife.model.contest.ContestDAO;
import iii.runninglife.model.contest.ContestDAOimpl;
import iii.runninglife.model.contest.ContestService;
import iii.runninglife.model.contest.ContestVO;
import iii.runninglife.model.event.EventDAO;
import iii.runninglife.model.event.EventDAOimpl;
import iii.runninglife.model.event.EventVO;
import iii.runninglife.model.member.MemberVO;
import iii.runninglife.model.runner.RunnerDAO;
import iii.runninglife.model.runner.RunnerDAOimpl;
import iii.runninglife.model.runner.RunnerForm;
import iii.runninglife.model.runner.RunnerService;
import iii.runninglife.model.runner.RunnerVO;
import iii.runninglife.model.team.TeamDAO;
import iii.runninglife.model.team.TeamDAOimpl;
import iii.runninglife.model.team.TeamVO;

@Controller
@SessionAttributes("member")
public class EventController {

	@Autowired
	private ContestDAO contestDAO;
	@Autowired
	private EventDAO eventDAO;
	@Autowired
	private TeamDAO teamDAO;
	@Autowired
	private RunnerDAO runnerDAO;
	@Autowired
	private ClothesDAO clothesDAO;
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
	@Autowired
	private RunnerService runnerService;

	// show all some contests
	@RequestMapping(value = "/contest", method = RequestMethod.GET)
	public String showAllContests(Model model, HttpServletRequest req,
			@RequestParam(required = false, value = "page") Integer page) {
		// Integer pageSize = 5;
		// 2016-08-08
		int countPage = 1;
		if (page == null) {
			page = 1;
		}
		List<ContestVO> contests = new ArrayList<>();
		if (req.getParameter("year") != null && req.getParameter("month") != null
				&& Integer.valueOf(req.getParameter("year")) != 0 && Integer.valueOf(req.getParameter("month")) != 0) {
			Integer year = Integer.valueOf(req.getParameter("year"));
			Integer month = Integer.valueOf(req.getParameter("month"));
			Date date = Date.valueOf(year + "-" + month + "-01");
			contests = contestService.QueryContest2(year, month, page);
			countPage = contestDAO.countPageBetweenDate(year, month);
		} else {
			contests = contestDAO.page(page);
			countPage = contestDAO.countPage();
		}
		model.addAttribute("current", countPage);
		model.addAttribute("countPage", countPage);
		model.addAttribute("contests", contests);
		return "contest";
	}

	// show some contests
	// @RequestMapping(value = "/contest/search", method = RequestMethod.GET)
	// public String showQueryContests(Model model, HttpServletRequest req) {
	//
	// System.out.println(req.getParameter("month"));
	// System.out.println(req.getParameter("year"));
	// List<ContestVO> contests = contestDAO.getAll();
	// Date begin = Date.valueOf("2016-08-01");
	// Date end = Date.valueOf("2016-12-02");
	// List<ContestVO> queryContests = contestService.QueryContest(begin, end);
	// model.addAttribute("contests", queryContests);
	// return "contest";
	// }

	// show 1contest
	@RequestMapping(value = "/contest/{contestID}", method = RequestMethod.GET)
	public String showContest(@PathVariable int contestID, Model model) {
		List<TeamVO> teams = teamDAO.getTeamById(contestID);
		List<EventVO> events = eventDAO.getEventById(contestID);
		List<ContestVO> contests = contestDAO.findByPrimaryKey2(contestID);
		ContestVO contest = contests.get(0);
		// ContestVO contest=contestDAO.findByPrimaryKey(contestID);
		List<ClothesVO> clothes = clothesDAO.getAll();
		List<RunnerVO> runners = runnerDAO.getList(contestID);
		List<RunnerVO> mycontest =runnerDAO.getMyContest("arthur");
		// 修正時間
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 (E)");
		String start = sdf2.format(contest.getStartDate());
		long timer = contest.getStartDate().getTime();
		
		model.addAttribute("timer", timer);
		model.addAttribute("start", start);
		model.addAttribute("events", events);
		model.addAttribute("teams", teams);
		model.addAttribute("contest", contest);
		model.addAttribute("clothes", clothes);
		model.addAttribute("runners", runners);
		model.addAttribute("mycontest", mycontest);
		return "detail";
	}

	// show contest form
	@RequestMapping(value = "/contest/edit", method = RequestMethod.GET)
	public String showUpdateContestForm(Model model, HttpServletRequest req) {
		ContestVO contest = new ContestVO();
		try {
			Integer id = Integer.valueOf(req.getParameter("id"));
			System.out.println(id);
			System.out.println("修改賽事:" + id);
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

		ContestVO contest = (ContestVO) contestDAO.findByPrimaryKey2(id).get(0);
		eventVO.setContest(contest);
		eventDAO.insert(eventVO);
		System.out.println("ajxa------------------------------------");
		return eventVO;
	}

	// delete event
	@RequestMapping(value = "/event/delete", method = RequestMethod.POST, produces = "text/html; charset=UTF-8") // produces
																													// =
																													// "text/html;
																													// charset=UTF-8"
	public @ResponseBody String deleteEvent(HttpServletResponse response, @RequestParam Integer id) {
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
	public String ContestApply(@ModelAttribute RunnerVO runner, @SessionAttribute MemberVO member, Model model,
			HttpServletRequest req,HttpServletResponse resp) {
		Integer id = runner.getPk().getContestID();

		int age = 20;// 從member取出年齡
		// age =member.getAge();
		List<TeamVO> list = teamDAO.getTeamById(id);
		TeamVO yourTeam = list.get(list.size() - 1);// 預設最年輕組
		for (TeamVO team : list) {
			System.out.println(team);
			if (team.getAgeRange() <= age && team.getAgeRange() + 9 > age) {
				age = team.getAgeRange();
				yourTeam = team;
				System.out.println("被分派到組別:" + team.getTeamName());
				System.out.println("組別範圍:" + team.getAgeRange() + "~" + (team.getAgeRange() + 9));
			}
		}
		runner.setTeamID(yourTeam.getTeamID());
		runner.setStatus("未繳費");
		try {
			String status = runnerDAO.insert(runner);
			ContestVO contest = contestDAO.findByPrimaryKey(runner.getPk().getContestID());
			mailService.sendApplyEmail(member, contest);
			System.out.println(status);
		} catch (Exception ex) {
			System.out.println("-----------------------------------------------");
			return "redirect:/contest/" + id+"?status=fail";
		}
		return "redirect:/contest/" + id+"?status=success";
	}

	// show update runner form
	@RequestMapping(value = "/runner/{contestID}", method = RequestMethod.GET)
	public String showScore(@PathVariable Integer contestID,Model model) {

		List<RunnerVO> list = runnerDAO.getList(contestID);
		RunnerForm runnerForm = new RunnerForm();
		runnerForm.setRunners(list);
		
		List<EventVO> events = eventDAO.getEventById(contestID);
		List<ClothesVO> clothes = clothesDAO.getAll();
		model.addAttribute("clothes", clothes);
		model.addAttribute("events", events);
		model.addAttribute("runnerForm", runnerForm);

		return "runnerform";
	}

	// updateAll
	@RequestMapping(value = "/runner/update", method = RequestMethod.POST)
	public String updateRunner(@ModelAttribute RunnerForm runnerForm,@RequestParam(name="test_length") Integer pageSize, HttpServletRequest req) {
		runnerService.updateAllRunner(runnerForm, pageSize);
		System.out.println(req.getHeader("Referer"));
		
		return "redirect:"+req.getHeader("Referer");
	}

	@RequestMapping("email")
	public String emailtest(Model model, @SessionAttribute("member") MemberVO member) {
		return "/../../index";
	}

	@RequestMapping(value = "/api/score/{contestID}/{eventID}/{teamID}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody List<RunnerVO> apiQueryScore(@PathVariable Integer contestID, @PathVariable Integer eventID,
			@PathVariable Integer teamID) {
		List<RunnerVO> list = new ArrayList<>();
		list = runnerDAO.getScoreGroup(contestID, eventID, teamID);
		for (RunnerVO a : list) {
			System.out.println(a);
		}
		return list;
	}

	@ModelAttribute("member")
	public MemberVO login() {
		MemberVO member = new MemberVO();
		member.setEmail("artashur@gmail.com");
		member.setLastName("Arthur");
		member.setMemberID("admin");
		return member;
	}
	// @ModelAttribute("contests")
	// public List<ContestVO> getContests(){
	// List<ContestVO>contests =contestDAO.getAll();
	//
	// return contests;
	// }
}
