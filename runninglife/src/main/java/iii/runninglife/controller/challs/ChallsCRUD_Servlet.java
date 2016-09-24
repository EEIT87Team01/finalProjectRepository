package iii.runninglife.controller.challs;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import iii.runninglife.model.challdata.ChallDataCRUDService;
import iii.runninglife.model.challdata.ChallDataVO;
import iii.runninglife.model.challdata.ChallDataPK;
import iii.runninglife.model.challs.ChallsCRUDService;
import iii.runninglife.model.challs.ChallsVO;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;


@Controller
@RequestMapping(value = "/challenge", produces = "text/plain;charset=UTF-8")
@SessionAttributes("membersVO")
public class ChallsCRUD_Servlet {
	
	@Autowired
	ChallsCRUDService challsCRUDService;
	@Autowired
	ChallDataCRUDService challDataCRUDService;
	@Autowired
	MembersInterface mdao;
	
	@RequestMapping("/")
	public String challengePage(@ModelAttribute MembersVO membersVO){ 
		return "challenge/challenge";
	}
	@RequestMapping("/createChall")
	public String createChallengePage(){ return "challenge/createChall";}
	
	@RequestMapping("/ingChall")
	public ModelAndView ingChallengePage(@ModelAttribute MembersVO membersVO){
		return new ModelAndView("challenge/ingChall", "challenDataList", 
				challDataCRUDService.memberProcessingChallService(membersVO.getMemberID()));
	}
	
	@RequestMapping("/finishChall")
	public ModelAndView finishChallengePage(@ModelAttribute MembersVO membersVO){ 
		return new ModelAndView("challenge/finishChall", "challengeDataList", 
				challDataCRUDService.memberFinishChallService(membersVO.getMemberID()));
	}
	
	@RequestMapping("/finishChallDetail/{challenID}")
	public ModelAndView finishChallengeDetailPage(@PathVariable String challenID, @ModelAttribute MembersVO membersVO){
//		challsCRUDService.searchOneService(challenID).getChallDatas();
		return new ModelAndView("challenge/finishChallDetail", "challengeData", 
				challDataCRUDService.searchOneService(new ChallDataPK(challsCRUDService.searchOneService(challenID), membersVO)));
	}
    
	@RequestMapping(value = "/searchChalls.do", method = RequestMethod.GET)
	public @ResponseBody String searchChalls() {
		List<ChallsVO> allChall = challsCRUDService.searchAllService();
		String challjson = new Gson().toJson(allChall);
		return challjson;
	}
	
	@RequestMapping(value = "/ingChallDetail/{challenID}", method = RequestMethod.GET)
	public ModelAndView searchChall(@PathVariable String challenID, @ModelAttribute MembersVO membersVO) {
		return new ModelAndView("challenge/ingChallDetail","challengeData",
				challDataCRUDService.searchOneService(new ChallDataPK(challsCRUDService.searchOneService(challenID), membersVO)));
	}
	
	@RequestMapping(value = "/searchChallByDate.do", method = RequestMethod.GET)
	public @ResponseBody String searchChallByDate() {//@RequestParam String challenID
		List<ChallsVO> allChall = challsCRUDService.searchByDateService();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String challjson = gson.toJson(allChall);
		return challjson;
	}
	
	@RequestMapping(value = "/searchChallByEndDate.do", method = RequestMethod.GET)
	public @ResponseBody String searchChallByEndDate() {//@RequestParam String challenID
		List<ChallsVO> allChall = challsCRUDService.searchByEndDateService();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String challjson = gson.toJson(allChall);
		return challjson;
	}
	
	@RequestMapping(value = "/searchChallByMemberFinish.do", method = RequestMethod.GET)
	public @ResponseBody String searchChallByMemberFinish(@ModelAttribute MembersVO membersVO) {//@RequestParam String challenID
		List<ChallDataVO> allChall = challDataCRUDService.memberFinishChallService(membersVO.getMemberID());
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String challjson = gson.toJson(allChall);
		return challjson;
	}
	
	@RequestMapping(value = "/searchChallByStartDate.do", method = RequestMethod.GET)
	public @ResponseBody String searchChallByStartDate() {//@RequestParam String challenID
		List<ChallsVO> allChall = challsCRUDService.searchByStartDateService();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String challjson = gson.toJson(allChall);
		return challjson;
	}
	
	@RequestMapping(value = "/createChall.do", method = RequestMethod.POST, produces = "application/json")    //,@RequestParam String founderID                                                                                                                                                                     
	public void createChall(@RequestParam String challenName,@RequestParam String locationID,@RequestParam String challenDistance,@RequestParam String challenStartTime,@RequestParam String challenEndTime,@RequestParam String comment,@RequestParam String founderID) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parseS = sdf.parse(challenStartTime);
		Date parseE = sdf.parse(challenEndTime);
        java.sql.Date dateS = new java.sql.Date(parseS.getTime());
        java.sql.Date dateE = new java.sql.Date(parseE.getTime());
		double challenDistanceD=Double.valueOf(challenDistance);
		int allChall = challsCRUDService.insertService(challenName,locationID,challenDistanceD,dateS,dateE,comment,"c:/",mdao.selectOne(founderID));
		System.out.println(allChall);
	}
	
	@RequestMapping(value = "/deleteChall.do", method = RequestMethod.DELETE)
	public void deleteAd(@RequestParam String challenID) {
		challsCRUDService.deleteService(challenID);
	}
	
	
}
