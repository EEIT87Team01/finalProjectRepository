package iii.runninglife.controller.photobase;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import iii.runninglife.controller.loginController.LoginService;
import iii.runninglife.model.photobase.PhotoBaseService;

@RestController
@RequestMapping("/photoController")
public class PhotoController {

	@Autowired
	PhotoBaseService PhotoSvc;
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/getPhoto.do", method = RequestMethod.GET)
	public @ResponseBody String getPhoto(HttpServletResponse res,@RequestParam String photoID) throws IOException {
		res.setContentType("image/jpeg"); 
		OutputStream out = res.getOutputStream();
		byte[] photo = PhotoSvc.getPhoto(photoID, out);
		String gson = new Gson().toJson(photo);
		return gson;
	}
	

	@RequestMapping(value = "/getMemberPhoto.do", method = RequestMethod.POST)
	public void getPhotoByte(HttpServletRequest req,@RequestParam String memberID) throws IOException, ServletException {
		List<Part> fileParts = req.getParts().stream().filter(part -> "file1".equals(part.getName()))
				.collect(Collectors.toList());
		for (Part filePart : fileParts) {
			InputStream is = filePart.getInputStream();
			byte[] bytes = IOUtils.toByteArray(is);
			loginService.getPhotoFromByte(memberID, bytes);
		}
	}
}