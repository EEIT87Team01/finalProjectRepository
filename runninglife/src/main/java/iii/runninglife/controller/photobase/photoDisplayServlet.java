package iii.runninglife.controller.photobase;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iii.runninglife.model.photobase.PhotoBaseService;

/**
 * Servlet implementation class photoDisplayServlet
 */
@WebServlet("/photoDisplayServlet")
public class photoDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public photoDisplayServlet() {
        super();
        // TODO Auto-generated constructor stu
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			PhotoBaseService svc = new PhotoBaseService();
			String[] photoIDAry = req.getParameter("imageId").split(",,,");
			for(String photoID : photoIDAry){
				System.out.println(svc.getPhoto(photoID));
				String photo = svc.getPhoto(photoID);
	
	
	//			ServletOutputStream fos = res.getOutputStream();
	//			BufferedOutputStream bos = new BufferedOutputStream(fos);
	//			pw.println("data:image/*;base64,"+photo);
	//			System.out.println( photo.getBytes());
	//			System.out.println(imageBytes);
	//			res.setContentType("text/html; charset=UTF-8");
	//			res.getOutputStream();
	//			res.setContentLength(imageBytes.length);
	//			res.getOutputStream().write(imageBytes);
	//			
				
	//			String fileName = "1.jpg";
	//			FileInputStream fis = new FileInputStream(new File("c:\\photo\\" + fileName));
	//			BufferedInputStream bis = new BufferedInputStream(fis);
	//			ServletOutputStream fos = res.getOutputStream();
	//			BufferedOutputStream bos = new BufferedOutputStream(fos);
	//			try
	//			{
	//				byte[] buffer = new byte[1024];
	//				int len = 0;
	//				while ((len = bis.read(buffer)) > -1)
	//					bos.write(buffer, 0, len);
	//			}finally
	//			{
	//				bos.close();
	//				bis.close();
	//				fis.close();
	//			}
			}
			RequestDispatcher view = req.getRequestDispatcher("/testt.jsp");
			view.forward(req,res);
	}

}
