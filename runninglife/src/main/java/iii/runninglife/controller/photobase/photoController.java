package iii.runninglife.controller.photobase;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import iii.runninglife.model.photobase.PhotoBaseService;
@RestController
@RequestMapping("/photoController")
public class photoController {
	
	@Autowired
	PhotoBaseService PhotoSvc;
	@RequestMapping(value = "/getPhoto.do", method = RequestMethod.POST)
	public @ResponseBody String getPhoto(HttpServletRequest req,String photoID,HttpServletResponse res) throws IOException {
		String photo = PhotoSvc.getTestPhoto(photoID);
		System.out.println(photo);
		String gson = new Gson().toJson(photo);
		System.out.println(gson);
		return gson;
	}
}
