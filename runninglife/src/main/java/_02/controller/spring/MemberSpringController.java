package _02.controller.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import _02.model.members.MembersDAO;
import _02.model.members.MembersVO;

@Controller
public class MemberSpringController {

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("account") String account, @RequestParam("pass") String password, HttpServletRequest req){
		MembersDAO mdao = new MembersDAO();
		MembersVO mvo = mdao.findByAccount(account);
		if (password.equals(mvo.getPassword())){
			req.getSession().setAttribute("member", mvo);
			return new ModelAndView("MemberInfo","member",mvo);
		} else {
			return new ModelAndView("LoginError","member",mvo);
		}
	}
}
