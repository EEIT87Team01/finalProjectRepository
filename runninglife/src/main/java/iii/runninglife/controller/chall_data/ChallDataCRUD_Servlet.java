package iii.runninglife.controller.chall_data;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import iii.runninglife.model.challdata.ChallDataCRUDService;
import iii.runninglife.model.challdata.ChallDataVO;
import iii.runninglife.model.challdata.ChallDataPK;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;

@Controller
@RequestMapping("/challenData")
@SessionAttributes("membersVO")
public class ChallDataCRUD_Servlet{
	
	@Autowired
	ChallDataCRUDService challDataCRUDService;
	@Autowired
	MembersInterface mdao;
	
	
	@RequestMapping(value = "/searchChallData.do", method = RequestMethod.GET)
	public @ResponseBody String searchChallData() {
		List<ChallDataVO> allChallData = challDataCRUDService.searchAllService();
		String challDatajson = new Gson().toJson(allChallData);
		return challDatajson;
	}
	
	@RequestMapping(value = "/searchChallDataFromChallenID.do", method = RequestMethod.GET)
	public @ResponseBody String searchChallDataFromChallenID(@RequestParam String challenID) {
		List<ChallDataVO> allChallData = challDataCRUDService.challProgressService(challenID);
		String challDatajson = new Gson().toJson(allChallData);
		return challDatajson;
	}
	
	@RequestMapping(value = "/searchChallDataFromMemberID.do", method = RequestMethod.GET)
	public @ResponseBody String searchChallDataFromMemberID(@RequestParam String memberID) {
		List<ChallDataVO> allChallData = challDataCRUDService.memberChallProgressService(memberID);
		String challDatajson = new Gson().toJson(allChallData);
		return challDatajson;
	}
	
	@RequestMapping(value = "/searchChallDataFromMemberIDProcessing.do", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ChallDataVO> searchChallDataFromMemberIDProcessing(@ModelAttribute MembersVO membersVO) {
		return challDataCRUDService.memberProcessingChallService(membersVO);
	}
	
	@RequestMapping(value = "/searchOneChallData.do", method = RequestMethod.GET)
	public @ResponseBody String searchOneChallData(@RequestParam String challenID,@RequestParam String memberID) {
		ChallDataPK challDataPK=challDataCRUDService.setTwoIDService(challenID, memberID);
		ChallDataVO aChallData = challDataCRUDService.searchOneService(challDataPK);
		String ChallDatajson = new Gson().toJson(aChallData);
		return ChallDatajson;
	}
	
	@RequestMapping(value = "/UpdateChallData.do", method = RequestMethod.POST)
	public void UpdateChallData(@RequestParam String challenID,		@RequestParam String memberID,
								@RequestParam Timestamp finishTime, @RequestParam double processLength,
								@RequestParam String duration,		@RequestParam String status, 
								@RequestParam String isFounder) {
		ChallDataPK challDataPK=challDataCRUDService.setTwoIDService(challenID, memberID);
//		if(new ChallDataCRUDService().checkService(challDataPK)==0){
//			new ChallDataCRUDService().insertService(challDataPK, finishTime, processLength, duration);
//		}else{
			new ChallDataCRUDService().updateService(challDataPK, finishTime, processLength, duration, isFounder);
//		}
	}
	
	@RequestMapping(value = "/createChallData.do", method = RequestMethod.GET)
	public void createChallData(@RequestParam String challenID,@RequestParam String memberID) {
		ChallDataPK challDataPK=challDataCRUDService.setTwoIDService(challenID, memberID);
		java.sql.Timestamp d=new java.sql.Timestamp(System.currentTimeMillis());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = sdf.format(d);
		new ChallDataCRUDService().insertService(challDataPK, d, 0, "0000000", "0", "0");
	}
	


}
