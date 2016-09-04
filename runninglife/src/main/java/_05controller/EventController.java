package _05controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import _05model.clothes.ClothesDAOimpl;
import _05model.contest.ContestDAOimpl;
import _05model.contest.ContestVO;
import _05model.event.EventDAOimpl;
import _05model.event.EventVO;
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
	@Autowired
	private ContestFormValidator contestFormValidator;

	// show all contest
	@RequestMapping("contest")
	public String showAllContests(Model model) {
		List<ContestVO> contests = contestDAO.getAll();
		model.addAttribute("contests", contests);
		return "contest";
	}

	// show contest
	@RequestMapping(value="/contest/{contestID}", method = RequestMethod.GET)
	public String showContest(@PathVariable int contestID, Model model) {
		List<TeamVO> teams = teamDAO.getTeamById(contestID);
		List<EventVO> events = eventDAO.getEventById(contestID);
		ContestVO contest = contestDAO.findByPrimaryKey(contestID);
		// 修正時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		String begin = sdf.format(contest.getRegistrationBegin());
		String end = sdf.format(contest.getRegistrationEnd());
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 (E)");
		String start = sdf2.format(contest.getStartDate());
		java.util.Date millseconds = null;
		try {
			millseconds = sdf.parse(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long timer = millseconds.getTime();
		System.out.println(timer);
		model.addAttribute("timer", timer);
		model.addAttribute("start", start);
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
		model.addAttribute("events", events);
		model.addAttribute("teams", teams);
		model.addAttribute("contest", contest);
		return "detail";
	}

	// show add form
	@RequestMapping(value = "/contest/add", method = RequestMethod.GET)
	public String showAddContestForm(Model model) {
		return null;
	}

	// show updateform
	@RequestMapping(value = "/contest/{id}/edit", method = RequestMethod.GET)
	public String showUpdateContestForm(@PathVariable("id") int id, Model model) {
		ContestVO contest = contestDAO.findByPrimaryKey(id);
		model.addAttribute("contest", contest);
		return "contestform";
	}

	// 錯誤訊息
	@InitBinder("contest")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(contestFormValidator);
	}

	/// save or update contest
	@RequestMapping(value = "/contest/{contestID}", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("contest") @Validated ContestVO contestVO, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("contest", contestVO);
			return "contestform";
		} else {

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if ((Integer) contestVO.getContestID() == null) {
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}

			// userService.saveOrUpdate(user);

			// POST/REDIRECT/GET
			return "redirect:/contest/" + contestVO.getContestID();
			// POST/FORWARD/GET
			// return "user/list";
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

	private String saveDirectory = "c:/run/upload/";
	
	@RequestMapping(value ="contest/{id}/upload",method = RequestMethod.POST)
	public String ContestPhotoUpload(@RequestParam CommonsMultipartFile[] fileUpload,@PathVariable("id") int id)
			throws Exception {


		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				if (!aFile.getOriginalFilename().equals("")) {
//					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
					File photo =new File(saveDirectory+id+".jpg");
					if(!photo.exists()){photo.mkdirs();}
					aFile.transferTo(photo);
					ContestVO contest= contestDAO.findByPrimaryKey(id);
					contest.setContestPhotoPath(id+".jpg");
					contestDAO.update(contest);
				}
			}
		}
		return "redirect:/contest";
	}

	@RequestMapping("email")
	public String emailtest(Model model) {
		MemberVO member = new MemberVO();
		member.setEmail("artashur@gmail.com");
		member.setLastName("Max");
		member.setMemberID("Maxcool#3433");
		mailService.sendEmail(member);
		model.addAttribute("A", member);
		return "/../../index";
	}

	// @ModelAttribute("contests")
	// public List<ContestVO> getContests(){
	// List<ContestVO>contests =contestDAO.getAll();
	//
	// return contests;
	// }
}
