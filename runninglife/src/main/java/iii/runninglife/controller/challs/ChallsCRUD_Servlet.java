package iii.runninglife.controller.challs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import iii.runninglife.model.challdata.ChallDataCRUDService;
import iii.runninglife.model.challdata.ChallDataVO;
import iii.runninglife.model.challdata.ChallDataPK;
import iii.runninglife.model.challs.ChallsCRUDService;
import iii.runninglife.model.challs.ChallsVO;
import iii.runninglife.model.friendRelationship.FriendRelationshipDAO_interface;
import iii.runninglife.model.friendRelationship.FriendRelationshipService_interface;
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
	FriendRelationshipService_interface friendRelationshipService;
	@Autowired
	MembersInterface mdao;
	
	@RequestMapping("/page")
	public String challengePage(@ModelAttribute MembersVO membersVO){ 
		return "challenge/challenge";
	}
	@RequestMapping("/createChallPage")
	public String createChallengePage(){ return "challenge/createChall";}
	
	@RequestMapping("/myChallenges")
	public ModelAndView myChallengePage(@ModelAttribute MembersVO membersVO){
		Map<String,Object> model = new HashMap<>();
		model.put("foundedChallengeList", challsCRUDService.findByFounderID(membersVO));
		model.put("ingChallengeList", challDataCRUDService.memberProcessingChallService(membersVO));
		model.put("finishChallengeList", challDataCRUDService.memberFinishChallService(membersVO));
		model.put("reservedChallengeList", challDataCRUDService.memberReservedChallService(membersVO));
		model.put("receivedRequestChallengeList", challDataCRUDService.findByMemberReceivedRequestService(membersVO));
		return new ModelAndView("challenge/myChallenges", model);
	}
	
	@RequestMapping("/detail/{challenID}")
	public ModelAndView challengeDetailPage(@PathVariable String challenID, @ModelAttribute MembersVO membersVO){
		Map<String, Object> model = new HashMap<>();
		Long nowTime = (new Date()).getTime();
		ChallsVO challenge = challsCRUDService.searchOneService(challenID);
		List<ChallDataVO> challengeDataList = challDataCRUDService.challProgressService(challenge);
		List<MembersVO> compare = new ArrayList<>();
		List<MembersVO> friends = new ArrayList<>();
		//預定的挑戰
		if(challenge.getChallenStartTime().getTime() > nowTime){
			model.put("challenge", challenge);
			model.put("myChallengeData", challDataCRUDService.searchOneService(new ChallDataPK(challenge, membersVO)));
			model.put("challengeDataList", challengeDataList); //"from ChallDataVO where challDataPK.challenID = :chall order by finishTime desc";
			for (ChallDataVO c:challengeDataList) {compare.add(c.getChallDataPK().getMemberID());}
			friends = friendRelationshipService.findByMemberIDALLFriendID(membersVO);
			friends.removeAll(compare);
			model.put("friends", friends);
			
			return new ModelAndView("challenge/reservedChallDetail", model);
		}
		//進行中的挑戰
		if(challenge.getChallenStartTime().getTime() <= nowTime && nowTime <= challenge.getChallenEndTime().getTime()){
			model.put("challenge", challenge);
			model.put("myChallengeData", challDataCRUDService.searchOneService(new ChallDataPK(challenge, membersVO)));
			model.put("challengeDataList", challengeDataList);
			for (ChallDataVO c:challengeDataList) {compare.add(c.getChallDataPK().getMemberID());}
			friends = friendRelationshipService.findByMemberIDALLFriendID(membersVO);
			friends.removeAll(compare);
			model.put("friends", friends);
			return new ModelAndView("challenge/ingChallDetail", model);
		}
		//結束的挑戰
		if(challenge.getChallenEndTime().getTime() < nowTime){
			model.put("challenge", challenge);
			model.put("myChallengeData", challDataCRUDService.searchOneService(new ChallDataPK(challenge, membersVO)));
			model.put("challengeDataList", challDataCRUDService.challProgressService(challenge));
			return new ModelAndView("challenge/finishChallDetail", model);
		}
		model.put("challenge", challenge);
		model.put("myChallengeData", challDataCRUDService.searchOneService(new ChallDataPK(challenge, membersVO)));
		model.put("challengeDataList", challDataCRUDService.challProgressService(challenge));
		return new ModelAndView("challenge/challDetail", model);
	}
	
	@RequestMapping("/finishChallDetail/{challenID}")
	public ModelAndView finishChallengeDetailPage(@PathVariable String challenID, @ModelAttribute MembersVO membersVO){
		Map<String, Object> model = new HashMap<>();
		ChallsVO challenge = challsCRUDService.searchOneService(challenID);
		model.put("challenge", challenge);
		model.put("myChallengrData", challDataCRUDService.searchOneService(new ChallDataPK(challenge, membersVO)));
		model.put("challengeDataList", challDataCRUDService.challProgressService(challenge));
		return new ModelAndView("challenge/challDetail", model);
	}
    
	@RequestMapping(value = "/searchChalls", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/searchChallByDate", method = RequestMethod.GET)
	public @ResponseBody String searchChallByDate() {//@RequestParam String challenID
		List<ChallsVO> allChall = challsCRUDService.searchByDateService();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String challjson = gson.toJson(allChall);
		return challjson;
	}
	
	@RequestMapping(value = "/searchChallByEndDate", method = RequestMethod.GET)
	public @ResponseBody String searchChallByEndDate() {//@RequestParam String challenID
		List<ChallsVO> allChall = challsCRUDService.searchByEndDateService();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String challjson = gson.toJson(allChall);
		return challjson;
	}
	
	@RequestMapping(value = "/searchChallByMemberFinish", method = RequestMethod.GET)
	public @ResponseBody String searchChallByMemberFinish(@ModelAttribute MembersVO membersVO) {//@RequestParam String challenID
		List<ChallDataVO> allChall = challDataCRUDService.memberFinishChallService(membersVO);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String challjson = gson.toJson(allChall);
		return challjson;
	}
	
	@RequestMapping(value = "/searchChallByStartDate", method = RequestMethod.GET)
	public @ResponseBody String searchChallByStartDate() {//@RequestParam String challenID
		List<ChallsVO> allChall = challsCRUDService.searchByStartDateService();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String challjson = gson.toJson(allChall);
		return challjson;
	}
	
	@RequestMapping(value = "/createChall", method = RequestMethod.POST)    //,@RequestParam String founderID                                                                                                                                                                     
	public ModelAndView createChall(@RequestParam String challenName,@RequestParam String locationID,@RequestParam String challenDistance,@RequestParam String challenStartTime,@RequestParam String challenEndTime,@RequestParam String comment,@RequestParam String founderID) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parseS = sdf.parse(challenStartTime);
		Date parseE = sdf.parse(challenEndTime);
        java.sql.Date dateS = new java.sql.Date(parseS.getTime());
        java.sql.Date dateE = new java.sql.Date(parseE.getTime());
		double challenDistanceD=Double.valueOf(challenDistance);
		MembersVO membersVO = mdao.selectOne(founderID);
		ChallsVO challsVO = challsCRUDService.insertService(challenName,locationID,challenDistanceD,dateS,dateE,comment,"c:/",membersVO);
		challDataCRUDService.insertService(new ChallDataPK(challsVO,membersVO), null, 0, "0000000", "1", "1");
		
		Map<String, Object> model = new HashMap<>();
		model.put("friends", friendRelationshipService.findByMemberIDALLFriendID(membersVO));
		model.put("challenVO", challsVO);
		
		return new ModelAndView("challenge/RequestFriend", model);
	}
	
	@RequestMapping(value = "/challenRequestFriend", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void challenRequestFriend(@RequestParam String memberID, @RequestParam String challenID){
		challDataCRUDService.insertService(
				new ChallDataPK(challsCRUDService.searchOneService(challenID),mdao.selectOne(memberID)), null , 0, "0000000", "0", "0");
	}
	
	@RequestMapping(value = "/deleteChall/{challenID}", method = RequestMethod.GET)
	public String deleteChallenge(@PathVariable String challenID) {
		challDataCRUDService.deleteByChanllegeID(challsCRUDService.searchOneService(challenID));
		challsCRUDService.deleteService(challenID);
		return "redirect:/challenge/myChallenges.do";
	}
	
	@RequestMapping(value = "/sendChallengeRequest.do", method = RequestMethod.GET)
	public void createChallData(@RequestParam String challenID,@RequestParam String memberID) {
		ChallDataPK challDataPK=challDataCRUDService.setTwoIDService(challenID, memberID);
		java.sql.Timestamp d=new java.sql.Timestamp(System.currentTimeMillis());
		challDataCRUDService.insertService(
				new ChallDataPK(challsCRUDService.searchOneService(challenID),mdao.selectOne(memberID)), d, 0, "0000000", "0", "0");
	}
	
	
}
