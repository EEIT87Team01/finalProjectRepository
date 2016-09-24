package iii.runninglife.controller.posts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/posts.do", method = RequestMethod.GET)
	public ModelAndView posts(HttpServletRequest req, @ModelAttribute("membersVO") MembersVO membersVO) {
		List<PostsVO> postsVO = postsDAO.getMemberPostAll(membersVO.getMemberID());
		List<PostsVO> postsVO2= postsDAO.getResponseAll();
		Map<String, Object> map = new HashMap<>();
		map.put("postsVO", postsVO);
		map.put("responseVO", postsVO2);
		return new ModelAndView("posts",map);
	}
//	@Bean(name = "multipartResolver")
	@RequestMapping(value = "/newPosts.do", method = RequestMethod.POST)
	public ModelAndView newPosts(HttpServletRequest req, @ModelAttribute("membersVO") MembersVO membersVO) throws IOException, ServletException {
		HttpSession session =req.getSession();
		session.setAttribute("memberVO", membersVO);
		String postsContent= req.getParameter("postsContent");	
		
		System.out.println(postsContent);
		System.out.println(membersVO);
		System.out.println(req.getPart("file1"));
		
		
			if(postsContent!=""){
				String fileName ;
				String path = "c:/test/";
				String imgPath = null;
				String imgPathtotal="";
			
			if (req.getPart("file1").getSize()!=0){ 
				System.out.println("getPartStart");
				 List<Part> fileParts = req.getParts().stream().filter(part -> "file1".equals(part.getName())).collect(Collectors.toList()); 
			    	System.out.println("uploadtest");
				    for (Part filePart : fileParts) {
				    	System.out.println("uploadtest2");
				        fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
						String extension=fileName.substring(fileName.lastIndexOf(46));
						System.out.println("extension:"+extension);
						fileName = globalSvc.findMaxSeq("photoID", new PhotoBaseVO())+extension;
						InputStream fileContent = filePart.getInputStream();
						File file = new File("C:/test", fileName);
						OutputStream out=new FileOutputStream(file);   
						imgPath = path+fileName;
						imgPathtotal+=",,,"+imgPath;
						photoSvc.newPhoto(imgPath);
						try{
						    byte[] buffer = new byte[1024];
						    int len = 0;
						    while((len=fileContent.read(buffer))>-1)
						    	out.write(buffer, 0, len);
						    	
						    }finally{
						    	out.close();
						    	fileContent.close();
						    }
					    }
				    postsSvc.newPosts(membersVO.getMemberID(), postsContent,imgPathtotal);
				}else{
					
					imgPath = null;
					postsSvc.newPosts(membersVO.getMemberID(), postsContent,imgPath);
					photoSvc.newPhoto(imgPath);
				}
			}
			List<PostsVO> postsVO = postsDAO.getMemberPostAll(membersVO.getMemberID());
			List<PostsVO> postsVO2= postsDAO.getResponseAll();
			System.out.println("newPosts");			
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("postsVO", postsVO);
			map.put("responseVO", postsVO2);
			System.out.println("newPosts");
			return new ModelAndView("redirect:/postsController/posts.do",map);
	}

	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public ModelAndView deletePosts(HttpServletRequest req, @ModelAttribute("membersVO") MembersVO membersVO) {
		String postID = req.getParameter("postID");
		postsSvc.deletePosts(membersVO.getMemberID(),postID);
		List<PostsVO> postsVO = postsDAO.getMemberPostAll(membersVO.getMemberID());
		List<PostsVO> postsVO2= postsDAO.getResponseAll();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("postsVO", postsVO);
		map.put("responseVO", postsVO2);		
		return new ModelAndView("redirect:/postsController/posts.do",map);
	}

//	
//	if("updatePosts".equals(action)){
//		String postID = req.getParameter("postID");
//		postsSvc = new PostsService();
//		postsSvc.deletePosts(member,postID);
//		postsVO = PostsDAO.getMemberPostAll(member);
//		postsVO2= PostsDAO.getResponseAll();
//		req.setAttribute("postsVO", postsVO);
//		req.setAttribute("responseVO", postsVO2);
//		System.out.println("deletePosts");
//		RequestDispatcher view = req.getRequestDispatcher("/forword/posts.jsp");
//		view.forward(req,res);
//	}
	
	@RequestMapping(value = "/goodOperation.do", method = RequestMethod.POST)
	public @ResponseBody String goodOperation(HttpServletRequest req) {
		String postID = req.getParameter("postID");
		String goodCount = req.getParameter("goodCount");
		String memberID = req.getParameter("memberID");
		postsSvc.goodOperation(memberID, postID);
		System.out.println(goodCount+","+postID+","+memberID);		
		goodCount = postsSvc.goodCount(postID);
		System.out.println("pass");
		return goodCount;
	}
	
	@RequestMapping(value = "/responsePosts.do", method = RequestMethod.POST)
	public ModelAndView responsePosts(HttpServletRequest req) {
		String postID = req.getParameter("postID");
		String responsePosts_content = req.getParameter("responsePosts_content");
		String memberID = req.getParameter("memberID");
		postsSvc.responsePosts(postID,memberID, responsePosts_content);
		List<PostsVO> postsVO = postsDAO.getMemberPostAll(memberID);
		List<PostsVO> postsVO2= postsDAO.getResponseAll();
		postsVO = postsDAO.getMemberPostAll(memberID);
		postsVO2= postsDAO.getResponseAll();
		Map<String, Object> map = new HashMap<>();
		map.put("postsVO", postsVO);
		map.put("responseVO", postsVO2);
		System.out.println("responsePosts");
		return new ModelAndView("redirect:/postsController/posts.do",map);
	}
	
	@RequestMapping(value = "/deleteResponsePosts.do", method = RequestMethod.POST)
	public ModelAndView deleteResponsePosts(HttpServletRequest req) {
		String postID = req.getParameter("postID");
		String responsePosts_content = req.getParameter("responsePosts_content");
		String memberID = req.getParameter("memberID");
		postsSvc.responsePosts(postID,memberID, responsePosts_content);
		List<PostsVO> postsVO = postsDAO.getMemberPostAll(memberID);
		List<PostsVO> postsVO2= postsDAO.getResponseAll();
		postsSvc.deleteResponsePosts(postID,memberID);
		postsVO = postsDAO.getMemberPostAll(memberID);
		Map<String, Object> map = new HashMap<>();
		map.put("postsVO", postsVO);
		map.put("responseVO", postsVO2);
		System.out.println("deleteResponsePosts");		
		return new ModelAndView("redirect:/postsController/posts.do",map);
		
	}
}


