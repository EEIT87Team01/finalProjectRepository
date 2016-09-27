package iii.runninglife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iii.runninglife.model.loginInformation.LoginInformationDAO;
import iii.runninglife.model.loginInformation.LoginInformationVO;
import iii.runninglife.model.members.MembersDAO;
import iii.runninglife.model.members.MembersVO;

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
