package iii.runninglife.controller.adsClick;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

import iii.runninglife.model.adsClick.AdsClickCRUDService;
import iii.runninglife.model.adsClick.AdsClickVO;
import iii.runninglife.model.adsClick.AdsClickPK;


@Controller
public class AdsClickCRUD_Servlet {
	
	@Autowired
	AdsClickCRUDService adsClickCRUDService;

	@RequestMapping(value = "/searchAdsClick.do", method = RequestMethod.GET)
	public @ResponseBody String searchAdsClick() {
		List<AdsClickVO> alladClick = adsClickCRUDService.searchAllService();
		String adClickjson = new Gson().toJson(alladClick);
		return adClickjson;
	}
	
	@RequestMapping(value = "/searchAdClick.do", method = RequestMethod.GET)
	public @ResponseBody String searchAdClick(@RequestParam String adID,@RequestParam java.sql.Date clickDay) throws SQLException {
		AdsClickPK adsClick_PK= adsClickCRUDService.setPKService(adID, clickDay);
		AdsClickVO allad = adsClickCRUDService.searchOneService(adsClick_PK);
		String adjson = new Gson().toJson(allad);
		return adjson;
	}
	
	@RequestMapping(value = "/createAdClick.do", method = RequestMethod.POST)
	public void createAdClick(@RequestParam String adID) throws ParseException {
		adsClickCRUDService.insertService(adID);
	}
	
	@RequestMapping(value = "/updateAdClick.do", method = RequestMethod.PUT)
	public void updateAdClick(@RequestParam String adID,@RequestParam String adName,@RequestParam String division,@RequestParam String adStartTime,@RequestParam String adEndTime,@RequestParam String site,@RequestParam String priority) throws ParseException, SQLException {
		adsClickCRUDService.updateService(adID);
	}
	


}
