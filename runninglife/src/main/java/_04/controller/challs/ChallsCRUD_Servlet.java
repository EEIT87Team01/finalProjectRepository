package _04.controller.challs;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _04.model.challs.ChallsVO;
import _04.model.challs.ChallsCRUDService;


@WebServlet("/ChallsCRUD_Servlet")
public class ChallsCRUD_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameterMap().containsKey("challenID")){
			ChallsVO achall=new ChallsCRUDService().searchOneService(request.getParameter("challenID"));
			request.setAttribute("chall", achall);
		}else{
			List<ChallsVO> allchall=new ChallsCRUDService().searchAllService();
			request.setAttribute("chall", allchall);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        //取資料		
		String challenName=request.getParameter("challenName");
		String locationID=request.getParameter("locationID");
		Double challenDistance=Double.valueOf(request.getParameter("challenDistance"));
		java.sql.Date challenStartTime=java.sql.Date.valueOf(request.getParameter("challenStartTime"));
		java.sql.Date challenEndTime=java.sql.Date.valueOf(request.getParameter("challenEndTime"));
		String comment=request.getParameter("comment");
		String image=request.getParameter("image");
		String founderID=request.getParameter("founderID");
		//call service
		new ChallsCRUDService().insertService(challenName,locationID,challenDistance,challenStartTime,challenEndTime,comment,image,founderID);
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//取資料
		String challenId=request.getParameter("challenId");
		//call service
		new ChallsCRUDService().deleteService(challenId);
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

}
