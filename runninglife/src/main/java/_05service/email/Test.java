package _05service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import _05model.member.MemberVO;
import _05service.email.config.AppConfig;

public class Test {
	
	@Autowired
	MailService mailService;
	
	public static void main(String args[]){
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	MemberVO member = new MemberVO();
	member.setEmail("artashur@gmail.com");
	member.setLastName("Max");
	member.setMemberID("Maxcool#3433");
	MailService mailService = (MailService) context.getBean("mailService");
//	mailService.sendEmail(member);
	}
}
