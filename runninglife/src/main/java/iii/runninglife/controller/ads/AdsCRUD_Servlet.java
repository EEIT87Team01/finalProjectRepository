package iii.runninglife.controller.ads;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

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

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.ads.AdsCRUDService;
import iii.runninglife.model.ads.AdsVO;
import iii.runninglife.model.photobase.PhotoBaseService;
import iii.runninglife.model.photobase.PhotoBaseVO;


@Controller
@MultipartConfig(location = "c:/test", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@RequestMapping(value = "/ads", produces = "text/plain;charset=UTF-8")
public class AdsCRUD_Servlet {
	
	@Autowired
	AdsCRUDService adsCRUDService;
	@Autowired
	PhotoBaseService photoSvc;
	@Autowired
	GlobalService globalSvc;
	
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
	
	@RequestMapping(value = "/searchDisplayAds.do", method = RequestMethod.GET)
	public @ResponseBody String searchDisplayAds() {
		List<AdsVO> allad = adsCRUDService.searchDisplayService();
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
	public ModelAndView createAd(HttpServletRequest req,@RequestParam String adName,@RequestParam String division,@RequestParam String adStartTime,@RequestParam String adEndTime,@RequestParam String site,@RequestParam String priority) throws ParseException, IOException, ServletException {
		
		System.out.println(req.getPart("file1"));
		String fileName;
		String storePath = "c:/test/";
		String imgPath = null;
		String extension;
		File file ;
		if (req.getPart("file1") != null) {
			if (req.getPart("file1").getSize() != 0) {
				System.out.println("getPartStart");
				List<Part> fileParts = req.getParts().stream().filter(part -> "file1".equals(part.getName()))
						.collect(Collectors.toList());
				for (Part filePart : fileParts) {
					fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
					extension = fileName.substring(fileName.lastIndexOf(46));
					fileName = globalSvc.findMaxSeq("photoID", new PhotoBaseVO()) + extension;
					InputStream fileContent = filePart.getInputStream();
					
					file = new File(storePath, fileName);
					OutputStream out = new FileOutputStream(file);
					try {
						byte[] buffer = new byte[1024];
						int len = 0;
						while ((len = fileContent.read(buffer)) > -1)
							out.write(buffer, 0, len);

					} finally {
						out.close();
						fileContent.close();
					}
					imgPath = storePath + fileName;
					String photoID = photoSvc.newPhoto(imgPath);
					System.out.println(photoID);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date parseS = sdf.parse(adStartTime);
					Date parseE = sdf.parse(adEndTime);
			        java.sql.Date dateS = new java.sql.Date(parseS.getTime());
			        java.sql.Date dateE = new java.sql.Date(parseE.getTime());
					int priorityI=Integer.valueOf(priority);
					adsCRUDService.insertService(adName,division,site,dateS,dateE,priorityI,photoID);
				}
			}
			
		} 
		return new ModelAndView("ads/adList");
	}
	
	@RequestMapping(value = "/updateAd.do", method = RequestMethod.POST)
	public ModelAndView updateAd(HttpServletRequest req,
								 @RequestParam String adID,
					             @RequestParam String adName,
					             @RequestParam String division,
					             @RequestParam String adStartTime,
					             @RequestParam String adEndTime,
					             @RequestParam String site,
					             @RequestParam String priority) throws ParseException, NumberFormatException, FileNotFoundException, IOException, ServletException {

		System.out.println(adID);
		System.out.println(adName);
		System.out.println(division);
		System.out.println(adStartTime);
		System.out.println(adEndTime);
		System.out.println(site);
		System.out.println(priority);
		System.out.println(req.getPart("file1"));
		String fileName;
		String storePath = "c:/test/";
		String imgPath = null;
		String extension;
		File file ;
		if (req.getPart("file1") != null) {
			if (req.getPart("file1").getSize() != 0) {
				System.out.println("getPartStart");
				List<Part> fileParts = req.getParts().stream().filter(part -> "file1".equals(part.getName()))
						.collect(Collectors.toList());
				for (Part filePart : fileParts) {
					fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
					extension = fileName.substring(fileName.lastIndexOf(46));
					fileName = globalSvc.findMaxSeq("photoID", new PhotoBaseVO()) + extension;
					InputStream fileContent = filePart.getInputStream();
					
					file = new File(storePath, fileName);
					OutputStream out = new FileOutputStream(file);
					try {
						byte[] buffer = new byte[1024];
						int len = 0;
						while ((len = fileContent.read(buffer)) > -1)
							out.write(buffer, 0, len);

					} finally {
						out.close();
						fileContent.close();
					}
					imgPath = storePath + fileName;
					String photoID = photoSvc.newPhoto(imgPath);
					System.out.println(photoID);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date parseS = sdf.parse(adStartTime);
					Date parseE = sdf.parse(adEndTime);
			        java.sql.Date dateS = new java.sql.Date(parseS.getTime());
			        java.sql.Date dateE = new java.sql.Date(parseE.getTime());
					int priorityI=Integer.valueOf(priority);
					adsCRUDService.updateService(adID,adName,division,site,dateS,dateE,priorityI,photoID);
					
				}
			}
		}
		return new ModelAndView("ads/adList");
	}
	
	@RequestMapping(value = "/deleteAd.do", method = RequestMethod.DELETE)
	public void deleteAd(@RequestParam String adID) {
		adsCRUDService.deleteService(adID);
	}

}
