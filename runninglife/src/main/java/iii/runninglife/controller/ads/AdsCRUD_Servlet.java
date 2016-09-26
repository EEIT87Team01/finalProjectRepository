package iii.runninglife.controller.ads;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import iii.runninglife.model.ads.AdsCRUDService;
import iii.runninglife.model.ads.AdsVO;


@Controller
@RequestMapping(value = "/ads", produces = "text/plain;charset=UTF-8")
public class AdsCRUD_Servlet {
	
	@Autowired
	AdsCRUDService adsCRUDService;
	
	@RequestMapping("/adList")
	public String adList(){
		return "ads/adList";
	}
	
	@RequestMapping("/adCreate")
	public String adCreate(){
		return "ads/adCreate";
	}
	
	@RequestMapping(value = "/adDetail/{adid}", method = RequestMethod.GET)
	public ModelAndView adDetail(@PathVariable String adid){
		return new ModelAndView("ads/adDetail","adid",adid);
	}
	
	@RequestMapping(value = "/searchAds.do", method = RequestMethod.GET)
	public @ResponseBody String searchAds() {
		List<AdsVO> allad = adsCRUDService.searchAllService();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String adjson = gson.toJson(allad);
		System.out.println(adjson);
		return adjson;
	}
	
	@RequestMapping(value = "/searchAd.do", method = RequestMethod.GET)
	public @ResponseBody String searchAd(@RequestParam String adID) {
		System.out.println(adID);
		AdsVO allad = adsCRUDService.searchOneService(adID);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String adjson = gson.toJson(allad);
		return adjson;
	}
	
	@RequestMapping(value = "/createAd.do", method = RequestMethod.POST)
	public void createAd(@RequestParam String adName,@RequestParam String division,@RequestParam String adStartTime,@RequestParam String adEndTime,@RequestParam String site,@RequestParam String priority) throws ParseException {
		System.out.println(adName);
		System.out.println(division);
		System.out.println(adStartTime);
		System.out.println(adEndTime);
		System.out.println(site);
		System.out.println(priority);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parseS = sdf.parse(adStartTime);
		Date parseE = sdf.parse(adEndTime);
        java.sql.Date dateS = new java.sql.Date(parseS.getTime());
        java.sql.Date dateE = new java.sql.Date(parseE.getTime());
		int priorityI=Integer.valueOf(priority);
		adsCRUDService.insertService(adName,division,site,dateS,dateE,priorityI,"c:/");
	}
	
	@RequestMapping(value = "/updateAd.do", method = RequestMethod.POST)
	public void updateAd(@RequestParam String adID,
			             @RequestParam String adName,
			             @RequestParam String division,
			             @RequestParam String adStartTime,
			             @RequestParam String adEndTime,
			             @RequestParam String site,
			             @RequestParam String priority) throws ParseException {

		System.out.println(adID);
		System.out.println(adName);
		System.out.println(division);
		System.out.println(adStartTime);
		System.out.println(adEndTime);
		System.out.println(site);
		System.out.println(priority);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parseS = sdf.parse(adStartTime);
		Date parseE = sdf.parse(adEndTime);
        java.sql.Date dateS = new java.sql.Date(parseS.getTime());
        java.sql.Date dateE = new java.sql.Date(parseE.getTime());
		int priorityI=Integer.valueOf(priority);
		adsCRUDService.updateService(adID,adName,division,site,dateS,dateE,priorityI,"c:/");
	}
	
	@RequestMapping(value = "/deleteAd.do", method = RequestMethod.DELETE)
	public void deleteAd(@RequestParam String adID) {
		adsCRUDService.deleteService(adID);
	}

}
