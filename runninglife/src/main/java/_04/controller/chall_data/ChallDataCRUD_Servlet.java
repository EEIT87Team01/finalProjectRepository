package _04.controller.chall_data;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _04.model.chall_data.ChallDataCRUDService;
import _04.model.chall_data.ChallDataVO;
import _04.model.chall_data.Two_ID;



@WebServlet("/ChallDataCRUD_Servlet")
public class ChallDataCRUD_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameterMap().containsKey("challenID")&&request.getParameterMap().containsKey("memberID")){
			Two_ID two_ID=new ChallDataCRUDService().setTwoIDService(request.getParameter("challenID"),request.getParameter("memberID"));
			ChallDataVO challData=new ChallDataCRUDService().searchOneService(two_ID);
			request.setAttribute("challData", challData);
		}else if(request.getParameterMap().containsKey("challenID")){
			List<ChallDataVO> challData=new ChallDataCRUDService().challProgressService(request.getParameter("challenID"));
			request.setAttribute("challData", challData);
		}else if(request.getParameterMap().containsKey("memberID")){
			List<ChallDataVO> challData=new ChallDataCRUDService().memberChallProgressService(request.getParameter("memberID"));
			request.setAttribute("challData", challData);
		}else{
			List<ChallDataVO> challData=new ChallDataCRUDService().searchAllService();
			request.setAttribute("challData", challData);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        //取資料		
		String challenID=request.getParameter("challenID");
		String memberID=request.getParameter("memberID");
		java.sql.Timestamp finishTime=java.sql.Timestamp.valueOf(request.getParameter("finishTime"));
		Double processLength=Double.valueOf(request.getParameter("processLength"));
		Double duration=Double.valueOf(request.getParameter("duration"));
		//call service
		Two_ID two_ID=new ChallDataCRUDService().setTwoIDService(challenID, memberID);
		new ChallDataCRUDService().insertService(two_ID, finishTime, processLength, duration);
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//取資料
		String challenID=request.getParameter("challenID");
		String memberID=request.getParameter("memberID");
		java.sql.Timestamp finishTime=java.sql.Timestamp.valueOf(request.getParameter("finishTime"));
		Double processLength=Double.valueOf(request.getParameter("processLength"));
		Double duration=Double.valueOf(request.getParameter("duration"));
		//call service
		Two_ID two_ID=new ChallDataCRUDService().setTwoIDService(challenID, memberID);
		new ChallDataCRUDService().updateService(two_ID, finishTime, processLength, duration);
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//取資料
		String challenID=request.getParameter("challenID");
		String memberID=request.getParameter("memberID");
		//call service
		Two_ID two_ID=new ChallDataCRUDService().setTwoIDService(challenID, memberID);
		new ChallDataCRUDService().deleteService(two_ID);
		RequestDispatcher rd=request.getRequestDispatcher("/ads/adlist.jsp");
		rd.forward(request, response);
	}

}
