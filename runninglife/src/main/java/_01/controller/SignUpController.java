package _01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import _01.model.loginInformation.LoginInformationDAO;
import _01.model.loginInformation.LoginInformationVO;
import _01.model.members.MembersDAO;
import _01.model.members.MembersVO;

@Controller
@RequestMapping("/sign")
public class SignUpController {
	
	MembersDAO mdao;
	LoginInformationDAO lfdao;
	
	@RequestMapping("/")
	public String sign(@RequestParam MembersVO membersVO,@RequestParam LoginInformationVO lfvo){
		mdao.insert(membersVO);
		lfvo.setMemberID(membersVO);
		lfdao.insert(lfvo);
		return null;
	}
}
