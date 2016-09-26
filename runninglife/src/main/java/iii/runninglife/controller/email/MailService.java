package iii.runninglife.controller.email;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import iii.runninglife.model.contest.ContestVO;
import iii.runninglife.model.members.MembersVO;

@Service
public class MailService {
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	Configuration freemarkerConfiguration;

	public void sendEmail(MembersVO member) {

		Map<String,Object> model = new HashMap<String,Object>();
		model.put("member", member);
		MimeMessagePreparator preparator = getMessagePreparator(model, "register");

		try {
			mailSender.send(preparator);
			System.out.println("Message has been sent.............................");
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	
	public void sendApplyEmail(MembersVO member,ContestVO contest ) {
		
		
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("member", member);
		model.put("contest", contest);
		MimeMessagePreparator preparator = getMessagePreparator(model, "apply");
		try {
			mailSender.send(preparator);
			System.out.println("Message has been sent.............................");
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private MimeMessagePreparator getMessagePreparator(Map<String, Object> model, String action) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				
				
				helper.setSubject("RunningLife送信測試");
				helper.setFrom("mizunarei520@gmail.com");
				helper.setTo(((MembersVO) model.get("member")).getEmail());

///			Map<String, Object> model = new HashMap<String, Object>();
//				model.put("member", member);
				// String action = "register";
				String text = geFreeMarkerTemplateContent(model, action);
				System.out.println("Template content : " + text);
				// use the true flag to indicate you need a multipart message
				helper.setText(text, true);
				// Additionally, let's add a resource as an attachment as well.
				// helper.addAttachment("cutie.png", new
				// ClassPathResource("linux-icon.png"));
			}
		};
		return preparator;
	}

	public String geFreeMarkerTemplateContent(Map<String, Object> model, String action) {
		StringBuffer content = new StringBuffer();
		try {
			content.append(FreeMarkerTemplateUtils
					.processTemplateIntoString(freemarkerConfiguration.getTemplate(action + ".ftl"), model));
			return content.toString();
		} catch (Exception e) {
			System.out.println("Exception occured while processing fmtemplate:" + e.getMessage());
		}
		return "";
	}
}