package _04.controller.articles;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import _04.model.articles.ArticlesCRUDService;
import _04.model.articles.ArticlesVO;


@WebServlet("/ArticlesCRUD_Servlet")
public class ArticlesCRUD_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameterMap().containsKey("articleId")){
			ArticlesVO article=new ArticlesCRUDService().searchOneService(request.getParameter("articleID"));
			request.setAttribute("article", article);
		}else{
			List<ArticlesVO> article=new ArticlesCRUDService().searchAllService();
			request.setAttribute("article", article);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        //取資料		
		String writerAccount=request.getParameter("writerAccount");
		String content = request.getParameter("content");
		String title=request.getParameter("title");
		String photoPath=request.getParameter("photoPath");
		java.sql.Timestamp createTime=java.sql.Timestamp.valueOf(request.getParameter("createTime"));
		String status=request.getParameter("status");
		int good=Integer.valueOf(request.getParameter("good"));
		//call service
		new ArticlesCRUDService().insertService(writerAccount, content, title, photoPath, createTime, status, good);
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//取資料
		int articleID=Integer.valueOf(request.getParameter("articleID"));
		String writerAccount=request.getParameter("writerAccount");
		Clob content=null;
		try {
			content = new javax.sql.rowset.serial.SerialClob(request.getParameter("content").toCharArray());
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title=request.getParameter("title");
		String photoPath=request.getParameter("photoPath");
		java.sql.Timestamp createTime=java.sql.Timestamp.valueOf(request.getParameter("createTime"));
		String status=request.getParameter("status");
		int good=Integer.valueOf(request.getParameter("good"));
		//call service
		new ArticlesCRUDService().updateService(articleID,writerAccount, content, title, photoPath, createTime, status, good);
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

//	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		//取資料
//		int articleId=Integer.valueOf(request.getParameter("articleId"));
//		//call service
//		new ArticlesCRUDService().deleteService(articleId);
//		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
//		rd.forward(request, response);
//	}

}
