package iii.runninglife.controller.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import iii.runninglife.controller.email.config.AppConfig;
import iii.runninglife.model.members.MembersVO;

public class Test {
	
	@Autowired
	MailService mailService;
	
	public static void main(String args[]){
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	MembersVO member = new MembersVO();
	member.setEmail("artashur@gmail.com");
	member.setLastName("Max");
	member.setMemberID("Maxcool#3433");
	MailService mailService = (MailService) context.getBean("mailService");
	mailService.sendEmail(member);
	}
}
