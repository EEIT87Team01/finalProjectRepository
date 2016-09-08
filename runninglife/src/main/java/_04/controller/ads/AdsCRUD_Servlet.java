package _04.controller.ads;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _04.model.ads.AdVO;
import _04.model.ads.AdCRUDService;



@WebServlet("/CRUDAds_Servlet")
public class AdsCRUD_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameterMap().containsKey("adId")){
			AdVO aad=new AdCRUDService().searchOneService(request.getParameter("adId"));
			request.setAttribute("ad", aad);
		}else{
			List<AdVO> allad=new AdCRUDService().searchAllService();
			request.setAttribute("ad", allad);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        //取資料		
		String adName=request.getParameter("adName");
		String division=request.getParameter("division");
		String link=request.getParameter("link");
		java.sql.Date adStartTime=java.sql.Date.valueOf(request.getParameter("adStartTime"));
		java.sql.Date adEndTime=java.sql.Date.valueOf(request.getParameter("adEndTime"));
		int priority=Integer.valueOf(request.getParameter("priority"));
		String image=request.getParameter("image");
		//call service
		new AdCRUDService().insertService(adName, division, link, adStartTime, adEndTime, priority, image);
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//取資料
		String adId=request.getParameter("adId");
		String adName=request.getParameter("adName");
		String division=request.getParameter("division");
		String link=request.getParameter("link");
		java.sql.Date adStartTime=java.sql.Date.valueOf(request.getParameter("adStartTime"));
		java.sql.Date adEndTime=java.sql.Date.valueOf(request.getParameter("adEndTime"));
		int priority=Integer.valueOf(request.getParameter("priority"));
		String image=request.getParameter("image");
		//call service
		new AdCRUDService().updateService(adId, adName, division, link, adStartTime, adEndTime, priority, image);
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//取資料
		String adId=request.getParameter("adId");
		//call service
		new AdCRUDService().deleteService(adId);
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

}
