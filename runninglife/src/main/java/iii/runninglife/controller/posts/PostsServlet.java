package iii.runninglife.controller.posts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.members.MembersVO;
import iii.runninglife.model.photobase.PhotoBaseService;
import iii.runninglife.model.posts.PostsDAO_interface;
import iii.runninglife.model.posts.PostsService;
import iii.runninglife.model.posts.PostsVO;

/**
 * Servlet implementation class postsServlet
 */
@WebServlet("/postsServlet")
@MultipartConfig
@SessionAttributes("membersVO")
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	PostsService postsSvc;
	@Autowired
	PhotoBaseService photoSvc;
	@Autowired
	GlobalService globalSvc;
	@Autowired
	PostsDAO_interface postsDAO;
	List<PostsVO> postsVO =null;
	List<PostsVO> postsVO2=null;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				doPost(req,res);
	}
		


	protected void doPost(HttpServletRequest req, HttpServletResponse res, @ModelAttribute MembersVO membersVO) throws ServletException, IOException {
				req.setCharacterEncoding("UTF-8");
				String action =req.getParameter("action");
				String member = membersVO.getMemberID();
				if("posts".equals(action)){
					postsVO = postsDAO.getMemberPostAll(member);
					postsVO2= postsDAO.getResponseAll();
					try{req.setAttribute("postsVO", postsVO);
						req.setAttribute("responseVO", postsVO2);
						String url ="/forword/posts.jsp";
						RequestDispatcher view = req.getRequestDispatcher(url);
						view.forward(req,res);
					}catch(Exception e){
						System.out.println("posts載入失敗");
					}
				}
				if("newPosts".equals(action)){
					String postsContent= req.getParameter("posts_content");	
					if(postsContent!=""){
						String fileName ;
						String path = "c:/test/";
						String imgPath = null;
						String imgPathtotal="";
					member = req.getParameter("memberID");
					System.out.println(req.getPart("file1"));
					if (req.getPart("file1").getSize()!=0){
						 List<Part> fileParts = req.getParts().stream().filter(part -> "file1".equals(part.getName())).collect(Collectors.toList()); 
					    	System.out.println("uploadtest");
						    for (Part filePart : fileParts) {
						    	System.out.println("uploadtest2");
						        fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
								String extension=fileName.substring(fileName.lastIndexOf(46));
								fileName = globalSvc.findMaxSeq("photoID", "photoBase")+extension;
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
						    postsSvc.newPosts(member, postsContent,imgPathtotal);
						}else{
							imgPath = null;
							postsSvc.newPosts(member, postsContent,imgPath);
							photoSvc.newPhoto(imgPath);
						}
					postsVO = postsDAO.getMemberPostAll(member);
					postsVO2= postsDAO.getResponseAll();
					req.setAttribute("postsVO", postsVO);
					req.setAttribute("responseVO", postsVO2);
					System.out.println("newPosts");
					RequestDispatcher view = req.getRequestDispatcher("/forword/posts.jsp");
					view.forward(req,res);
					}
				}
				
				if("deletePosts".equals(action)){
					String postID = req.getParameter("postID");
					postsSvc = new PostsService();
					postsSvc.deletePosts(member,postID);
					postsVO = postsDAO.getMemberPostAll(member);
					postsVO2= postsDAO.getResponseAll();
					req.setAttribute("postsVO", postsVO);
					req.setAttribute("responseVO", postsVO2);
					System.out.println("deletePosts");
					RequestDispatcher view = req.getRequestDispatcher("/forword/posts.jsp");
					view.forward(req,res);
				}
				
				if("updatePosts".equals(action)){
					String postID = req.getParameter("postID");
					postsSvc = new PostsService();
					postsSvc.deletePosts(member,postID);
					postsVO = postsDAO.getMemberPostAll(member);
					postsVO2= postsDAO.getResponseAll();
					req.setAttribute("postsVO", postsVO);
					req.setAttribute("responseVO", postsVO2);
					System.out.println("deletePosts");
					RequestDispatcher view = req.getRequestDispatcher("/forword/posts.jsp");
					view.forward(req,res);
				}
				
				if("goodOperation".equals(action)){
					String postID = req.getParameter("postID");
					String goodCount = req.getParameter("goodCount");
					String memberID = req.getParameter("memberID");
					postsSvc.goodOperation(memberID, postID);
					System.out.println(goodCount+","+postID+","+memberID);
					postsVO = postsDAO.getMemberPostAll(member);
					postsVO2= postsDAO.getResponseAll();
					req.setAttribute("postsVO", postsVO);
					req.setAttribute("responseVO", postsVO2);
					System.out.println("goodOperation");
					RequestDispatcher view = req.getRequestDispatcher("/forword/posts.jsp");
					view.forward(req,res);
				}	
				if("responsePosts".equals(action)){
					String postID = req.getParameter("postID");
					String responsePosts_content = req.getParameter("responsePosts_content");
					String memberID = req.getParameter("memberID");
					postsSvc.responsePosts(postID,memberID, responsePosts_content);
						postsVO = postsDAO.getMemberPostAll(member);
						postsVO2= postsDAO.getResponseAll();
						req.setAttribute("postsVO", postsVO);
						req.setAttribute("responseVO", postsVO2);
						System.out.println("responsePosts");
						RequestDispatcher view = req.getRequestDispatcher("/forword/posts.jsp");
						view.forward(req,res);
				}	
				if("deleteResponsePosts".equals(action)){
					String postID = req.getParameter("postID");
					postsSvc = new PostsService();
					postsSvc.deleteResponsePosts(postID,member);
					postsVO = postsDAO.getMemberPostAll(member);
					postsVO2= postsDAO.getResponseAll();
					req.setAttribute("postsVO", postsVO);
					req.setAttribute("responseVO", postsVO2);
					System.out.println("deleteResponsePosts");
					RequestDispatcher view = req.getRequestDispatcher("/forword/posts.jsp");
					view.forward(req,res);
				}
				
				if("reportPosts".equals(action)){
					System.out.println("reportPosts");
					
					RequestDispatcher view = req.getRequestDispatcher("/forword/posts_repotrt.jsp");
					view.forward(req,res);
				}
			
				if("goodCount".equals(action)){
					System.out.println("goodCount");
					RequestDispatcher view = req.getRequestDispatcher("/forword/profile.jsp");
					view.forward(req,res);
				}
				if("update_proflies".equals(action)){
					System.out.println("test");
					RequestDispatcher view = req.getRequestDispatcher("/forword/update_proflies.jsp");
					view.forward(req,res);
				}
				if("testt".equals(action)){
					String photoID = req.getParameter("photoID");
					res.setContentType("image/jpeg");
					PhotoBaseService PhotoSvc = new PhotoBaseService();
					String photo = PhotoSvc.getTestPhoto(photoID);
					String gson = new Gson().toJson(photo);
					
					req.setAttribute("gson", gson);
					RequestDispatcher view = req.getRequestDispatcher("/forword/testt.jsp");
					view.forward(req,res);
				}
				
	}

}
