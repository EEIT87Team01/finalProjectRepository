package iii.runninglife.controller.posts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.members.MembersVO;
import iii.runninglife.model.photobase.PhotoBaseService;
import iii.runninglife.model.photobase.PhotoBaseVO;
import iii.runninglife.model.posts.PostsDAO_interface;
import iii.runninglife.model.posts.PostsService;
import iii.runninglife.model.posts.PostsVO;

@RestController
@MultipartConfig(location="c:/test", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5*5, maxRequestSize=1024*1024*5*5)
@RequestMapping("/postsController")
@SessionAttributes("membersVO")
public class PostsController {
	
	@Autowired
	PostsService postsSvc;
	@Autowired
	PhotoBaseService photoSvc;
	@Autowired
	GlobalService globalSvc;
	@Autowired
	PostsDAO_interface postsDAO;
	
	
	@RequestMapping(value = "/personalPosts.do", method = RequestMethod.GET)
	public ModelAndView personalPosts(HttpServletRequest req,@RequestParam String membersID) {
		MembersVO memberVO = new MembersVO();
		memberVO.setMemberID(membersID);
		List<PostsVO> postsVO = postsSvc.getMemberPostAll(memberVO.getMemberID());
		List<PostsVO> postsVO2= postsSvc.getResponseAll();
		Map<String, Object> map = new HashMap<>();
		map.put("postsVO", postsVO);
		map.put("responseVO", postsVO2);
		return new ModelAndView("posts/personalPosts",map);
	}
	
	@RequestMapping(value = "/posts.do", method = RequestMethod.GET)
	public ModelAndView posts(HttpServletRequest req, @ModelAttribute("membersVO") MembersVO membersVO) {
		List<PostsVO> postsVO = postsSvc.getAll();
		List<PostsVO> postsVO2= postsSvc.getResponseAll();
		Map<String, Object> map = new HashMap<>();
		map.put("postsVO", postsVO);
		map.put("responseVO", postsVO2);
		return new ModelAndView("posts/posts",map);
	}
	
	@RequestMapping(value = "/profilePosts.do", method = RequestMethod.GET)
	public ModelAndView profilePosts(HttpServletRequest req, @ModelAttribute("membersVO") MembersVO membersVO) {
		List<PostsVO> postsVO = postsSvc.getMemberPostAll(membersVO.getMemberID());
		List<PostsVO> postsVO2= postsSvc.getResponseAll();
		Map<String, Object> map = new HashMap<>();
		map.put("postsVO", postsVO);
		map.put("responseVO", postsVO2);
		return new ModelAndView("posts/posts",map);
	}
	
	@RequestMapping(value = "/newPosts.do", method = RequestMethod.POST)
	public ModelAndView newPosts(HttpServletRequest req,@ModelAttribute("membersVO") MembersVO membersVO) throws IOException, ServletException {
		String contextPath =req.getContextPath();
		String postsContent= req.getParameter("postsContent");	
		ArrayList<String> list = new ArrayList<String>();
		if (postsContent != "") {
			String fileName;
			String storePath = "c:/test/";
			String imgPath = null;
			String imgPathtotal = "";
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
						imgPath = storePath + fileName;
						imgPathtotal += ",,," + imgPath;
						String photoID = photoSvc.newPhoto(imgPath);						
						list.add(photoID);
						try {
							byte[] buffer = new byte[1024];
							int len = 0;
							while ((len = fileContent.read(buffer)) > -1)
								out.write(buffer, 0, len);

						} finally {
							out.close();
							fileContent.close();
						}
					}
					postsSvc.newPostsWithImages(membersVO.getMemberID(), postsContent, imgPathtotal, list,contextPath);
				} else {
					imgPath = null;
					postsSvc.newPosts(membersVO.getMemberID(), postsContent, imgPath);
				}
			} else {
				imgPath = null;
				postsSvc.newPosts(membersVO.getMemberID(), postsContent, imgPath);
			}
		}
		return new ModelAndView("redirect:/postsController/posts.do");
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public ModelAndView deletePosts(@RequestParam String postID,@ModelAttribute("membersVO") MembersVO membersVO) {
		postsSvc.deletePosts(membersVO.getMemberID(), postID);
		return new ModelAndView("redirect:/postsController/posts.do");
	}
	
	@RequestMapping(value = "/goodOperation.do", method = RequestMethod.POST)
	public @ResponseBody String goodOperation(@RequestParam String postID,@RequestParam String goodCount,@RequestParam String memberID) {
		postsSvc.goodOperation(memberID, postID);
		goodCount = postsSvc.goodCount(postID);
		return goodCount;
	}
	
	@RequestMapping(value = "/responsePosts.do", method = RequestMethod.POST)
	public ModelAndView responsePosts(@RequestParam String postID,@RequestParam String responsePosts_content,@RequestParam String memberID) {
		postsSvc.responsePosts(postID, memberID, responsePosts_content);
		return new ModelAndView("redirect:/postsController/posts.do");
	}
	
	@RequestMapping(value = "/deleteResponsePosts.do", method = RequestMethod.POST)
	public ModelAndView deleteResponsePosts(@RequestParam String postID,@RequestParam String memberID) {
		postsSvc.deleteResponsePosts(postID, memberID);
		return new ModelAndView("redirect:/postsController/posts.do");
	}
	
	@RequestMapping(value = "/onePost.do", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody String onePost(@RequestParam String postID) {
		PostsVO onePosts = postsSvc.getOnePost(postID);
		String gson = new Gson().toJson(onePosts);
		return gson;
	}
}


