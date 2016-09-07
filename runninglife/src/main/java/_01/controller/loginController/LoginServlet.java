package _01.controller.loginController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _01.model.loginInformation.LoginInformationDAO;
import _01.model.loginInformation.LoginInformationPK;
import _01.model.loginInformation.LoginInformationVO;
import _01.model.members.MembersVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String  memberAccount = request.getParameter("memberAccount");
		String password = request.getParameter("password");
//		LoginInformationVO loginInfo = new LoginInformationVO();
//		LoginInformationPK loginInfoPK = new LoginInformationPK();
//		LoginInformationDAO loginInfoDAO = new LoginInformationDAO();
		Collection<String> errorMessage = new ArrayList<String>();
//		Collection<String> message = new ArrayList<String>();
		Map<String ,Object> InfoMsg = new HashMap<String ,Object>();
		request.setAttribute("ErrorMsg", errorMessage);
		
		request.setCharacterEncoding("UTF-8");

		/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		if(memberAccount == null || memberAccount.trim().length() == 0){
			errorMessage.add("請輸入帳號");
		}
		
		if (!errorMessage.isEmpty()) {
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("/pages/login/show.jsp");
			rd.forward(request, response);
			return;//程式中斷
		}
		
		if(password == null || password.trim().length() == 0){
			errorMessage.add("請輸入密碼");
		}	
		
		if (!errorMessage.isEmpty()) {
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("/pages/login/show.jsp");
			rd.forward(request, response);
			return;//程式中斷
		}
		

		LoginService loginService = new LoginService();
		InfoMsg = loginService.checkPassword(memberAccount, password);
		/***************************3.查詢完成,準備轉交(Send the Success view)*************/
		if(((String)InfoMsg.get("Msg")).equals("登入成功")){
			request.setAttribute("loginAccount", ((LoginInformationVO)InfoMsg.get("Info")).getMemberAccount().getMemberAccount());
			request.setAttribute("loginPassword", ((LoginInformationVO)InfoMsg.get("Info")).getPassword());
			request.setAttribute("message", (String)InfoMsg.get("Msg"));
			
			MembersVO membersVO = new MembersVO();
			membersVO = loginService.insertMember(InfoMsg);
			
			HttpSession session = request.getSession();
			session.setAttribute("membersVO", membersVO);
			
			RequestDispatcher rd = request.getRequestDispatcher("/pages/login/show.jsp");
			rd.forward(request, response);
			
		}else if(((String)InfoMsg.get("Msg")).equals("密碼錯誤")){
			request.setAttribute("loginAccount", ((LoginInformationVO)InfoMsg.get("Info")).getMemberAccount().getMemberAccount());
			
			request.setAttribute("errorMessage", InfoMsg.get("Msg"));
			RequestDispatcher rd = request.getRequestDispatcher("/pages/login/show.jsp");
			rd.forward(request, response);
			return;
		}else if(((String)InfoMsg.get("Msg")).equals("查無此帳號")){
			request.setAttribute("errorMessage", InfoMsg.get("Msg"));
			RequestDispatcher rd = request.getRequestDispatcher("/pages/login/show.jsp");
			rd.forward(request, response);
			return;
		}
		
//--------------------------------------------------------------------------------------		
		//servlet 無Service
		//輸入帳號CO Hibernate
//		loginInfo = loginInfoDAO.selectOne(loginInfoPK);
//		if(loginInfo != null){
//			String dbAccount = loginInfo.getMemberAccount().getMemberAccount(); 
//			
//			if(dbAccount.equals(memberAccount)){
//				//輸入密碼CO Hibernate
//				
//				String dbPassword = loginInfo.getPassword().trim();
//				if(dbPassword != null && dbPassword.equals(password)){
//					
//				    message.add("登入成功");
//				    /***************************3.查詢完成,準備轉交(Send the Success view)*************/
//					request.setAttribute("loginAccount", loginInfoPK);
//					request.setAttribute("loginPassword", loginInfo);
//					request.setAttribute("message", message);
//					
//					MembersVO membersVO = new MembersVO();
//					MembersDAO membersDAO = new MembersDAO();
//					String memberID = null;
//					memberID = loginInfo.getMemberID().getMemberID();
//					membersVO.setMemberID(memberID);
////					System.out.println(loginInfo.getMemberID());
//					membersVO = membersDAO.selectOne(memberID);
////					UUID uuid = UUID.fromString(memberID);
////					membersVO = membersDAO.selectOne(uuid.toString().trim());
//					
//					HttpSession session = request.getSession();
//					session.setAttribute("membersVO", membersVO);
//					
//					RequestDispatcher rd = request.getRequestDispatcher("/pages/login/show.jsp");
//					rd.forward(request, response);
//					
//					/***************************其他可能的錯誤處理*************************************/
//				}else{
//					errorMessage.add("密碼錯誤");
//					request.setAttribute("loginAccount", loginInfoPK);
//
//					request.setAttribute("errorMessage", errorMessage);
//					RequestDispatcher rd = request.getRequestDispatcher("/pages/login/show.jsp");
//					rd.forward(request, response);
//					return;
//				}
//			}
//		}else{
//			errorMessage.add("查無此帳號");
//
//			request.setAttribute("errorMessage", errorMessage);
//			RequestDispatcher rd = request.getRequestDispatcher("/pages/login/show.jsp");
//			rd.forward(request, response);
//			return;
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
