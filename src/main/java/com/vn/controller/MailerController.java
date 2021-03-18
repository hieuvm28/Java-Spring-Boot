package com.vn.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.service.SummarizeService;


@Controller
public class MailerController {
	
	@Autowired
	SummarizeService summarizeService;
	
	@Autowired
	JavaMailSender mailer;

	@PostMapping("/sendEmail")
	public String sendEmail1(ModelMap model,@RequestParam("name") String name, @RequestParam("to") String to) {
		try {
			sendEmail(name, to);
			model.addAttribute("mess", "Send Email Sessufully");
			System.out.println("Gửi thành công");
			//model.addAttribute("staffGood",summarizeService.getListStaffGood());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Gửi thất bại");
			model.addAttribute("mess", "Send Email Failed");
		}		
		return "redirect:/admin";
	}


	
	public void sendEmail(String name, String to ) {
		
		String from = "hieuvmhe140703@gmail.com";
		String subject = "GIẤY TRIỆU TẬP QUÂN SỰ";
		String body = "Yêu cầu anh/chị: " + name + " đến ngay .... Em Hiếu test chức năng gửi Email, HeHe";
		try {
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);
			mailer.send(mail);	
			System.out.println("Gửi OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
