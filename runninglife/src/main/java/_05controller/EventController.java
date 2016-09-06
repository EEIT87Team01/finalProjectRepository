package _05controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
import _05validator.EventValidator;
import _05validator.FileValidator;

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
	@Autowired
	private FileValidator fileValidator;
	@Autowired
	private EventValidator eventValidator;

	// show all contest
	@RequestMapping(value="contest",method = RequestMethod.GET)
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
		EventVO event = new EventVO();
		model.addAttribute("event",event);
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
		ContestVO contest = new ContestVO();
		model.addAttribute("contest", contest);
		model.addAttribute("action", new Integer(1));
		return "contestform";
	}

	// show updateform
	@RequestMapping(value = "/contest/{id}/edit", method = RequestMethod.GET)
	public String showUpdateContestForm(@PathVariable("id") int id, Model model) {
		ContestVO contest = contestDAO.findByPrimaryKey(id);
		model.addAttribute("contest", contest);
		model.addAttribute("action", new Integer(2));
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

	/// add contest
	@RequestMapping(value = "/contest/add", method = RequestMethod.POST)
	public String SaveUser(@ModelAttribute("contest") @Validated ContestVO contestVO, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes, @RequestParam @Validated CommonsMultipartFile[] fileUpload) {
		if (result.hasErrors()) {
			return "contestform";
		} else {
			// 新增表單
			
			contestDAO.insert(contestVO);
			// 上傳圖片
			if (fileUpload != null && fileUpload.length > 0) {

				if (fileUpload[0].getSize() > 0) {
					System.out.println("Saving file: " + path + contestVO.getContestID() + fileUpload[0]
							.getOriginalFilename().substring(fileUpload[0].getOriginalFilename().indexOf(".")));

					try {
						fileUpload[0].transferTo(new File(path + contestVO.getContestID() + fileUpload[0]
								.getOriginalFilename().substring(fileUpload[0].getOriginalFilename().indexOf("."))));
						contestVO.setContestPhotoPath(contestVO.getContestID() + fileUpload[0].getOriginalFilename()
								.substring(fileUpload[0].getOriginalFilename().indexOf(".")));
						contestVO.setContestPhotoPath(contestVO.getContestID() + fileUpload[0].getOriginalFilename()
								.substring(fileUpload[0].getOriginalFilename().indexOf(".")));
						contestDAO.update(contestVO);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fileUpload[1].getSize() > 0) {
					System.out.println("Saving file: " + path + contestVO.getContestID() + "banner" + fileUpload[1]
							.getOriginalFilename().substring(fileUpload[1].getOriginalFilename().indexOf(".")));
					try {
						fileUpload[1].transferTo(new File(path + contestVO.getContestID() + "banner" + fileUpload[1]
								.getOriginalFilename().substring(fileUpload[1].getOriginalFilename().indexOf("."))));
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			// POST/REDIRECT/GET
			return "redirect:/contest/" + contestVO.getContestID();
			// POST/FORWARD/GET
			// return "user/list";
		}
	}

	/// update contest
	@RequestMapping(value = "/contest/{contestID}", method = RequestMethod.POST)
	public String UpdateUser(@ModelAttribute("contest") @Validated ContestVO contestVO, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes,
			@RequestParam @Validated CommonsMultipartFile[] fileUpload) {
		if (result.hasErrors()) {
			return "contestform";
		} else {
			// 更新表單
			contestDAO.update(contestVO);
			// 上傳圖片
			if (fileUpload != null && fileUpload.length > 0) {

				for (CommonsMultipartFile aFile : fileUpload) {
					if (aFile.getSize() > 0) {
						System.out.println("有檔案");
						System.out.println("Saving file: " + path + contestVO.getContestID()
								+ aFile.getOriginalFilename().substring(aFile.getOriginalFilename().indexOf(".")));

						try {
							aFile.transferTo(new File(path + contestVO.getContestID()
									+ aFile.getOriginalFilename().substring(aFile.getOriginalFilename().indexOf("."))));
							System.out.println("上傳圖片成功");
							contestVO.setContestPhotoPath(contestVO.getContestID()
									+ aFile.getOriginalFilename().substring(aFile.getOriginalFilename().indexOf(".")));
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
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
	
	
	
	@InitBinder("eventVO")
	protected void initBinderEvent(WebDataBinder binder) {
		binder.setValidator(eventValidator);
	}
	
	
	// add event
	@RequestMapping(value="/{id}/event/add",method =RequestMethod.POST,consumes="application/json",produces = "application/json; charset=UTF-8")
	public @ResponseBody EventVO addEvent(@PathVariable("id")Integer id,@RequestBody @Validated EventVO eventVO,BindingResult result){
		
		eventVO.setContestID(id);
		eventDAO.insert(eventVO);
		System.out.println(eventVO);
		System.out.println("ajxa------------------------------------");
		
		return eventVO;
	}
	
	//delete event
	@RequestMapping(value="/event/{id}/delete",method=RequestMethod.POST,produces = "text/html; charset=UTF-8")//produces = "text/html; charset=UTF-8"
	public @ResponseBody String deleteEvent(HttpServletResponse response,@PathVariable("id")Integer id){
		
		eventDAO.delete(id);
		System.out.println("刪除eventID="+id);
//		response.setCharacterEncoding("UTF-8");
		return "刪除成功";
	}
	
	// add team
	@RequestMapping(value="{id}/team/add",method =RequestMethod.POST,consumes="application/json",produces = "application/json; charset=UTF-8")
	public @ResponseBody TeamVO addTeam(@PathVariable("id")Integer id,@RequestBody  TeamVO teamVO,HttpServletResponse res){
		
		if(id>0){
		teamVO.setContestID(id);
		teamDAO.insert(teamVO);
		return null;}
		System.out.println("ajxa------------------------------------");
		return teamVO;
	}
	
	
	//delete team
	@RequestMapping(value="/team/delete",method=RequestMethod.POST,produces = "text/html; charset=UTF-8")//produces = "text/html; charset=UTF-8"
	public @ResponseBody String deleteTeam(HttpServletRequest req, @RequestParam Integer id){
		teamDAO.delete(id);
		System.out.println("刪除teamID="+id);
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
	
//	@RequestMapping(value = "/test", method = RequestMethod.POST)
//	public String testtest(HttpServletRequest req){
//		String param = (String) req.getAttribute("param");
//		System.out.println(param);
//		System.out.println(11111111);
//		return "aa";
//	}
	
	
	
	
	
	

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
