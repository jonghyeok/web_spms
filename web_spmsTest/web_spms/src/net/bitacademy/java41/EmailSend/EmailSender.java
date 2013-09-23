package net.bitacademy.java41.EmailSend;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import sdk.mail.MailHandler;
import sdk.mail.impl.SecureMailHandler;
import sdk.mail.impl.PlainMailHandler;

public class EmailSender {

	String email = null;
	String pw = null;
	
	public EmailSender(){
		System.out.println(email + "님이 비밀번호 찾기 신청!");
	}
	
	public EmailSender(String email, String pw){
		this.email = email;
		this.pw=pw;
	}
	
	public void sendGMail(){
		System.out.println("GMAIL라인 들어옴");
		System.out.println("Email : " + email);
		System.out.println("Pwd : " + pw);
		
		MailHandler mail = new SecureMailHandler("spms.manager@gmail.com", "spmsadmin");
		mail.setMailServer("smtp.gmail.com");
		mail.setSender("spms.manager@gmail.com");
		mail.setSenderName("SPMS_MANAGER");
		mail.setReceiver(email);
		mail.setSubject("SPMS 비밀번호 찾기");
		mail.setContent("<h1>SPMS</h1> <br> <h2>"+email+"님의 비밀번호는 "+pw+"입니다.</h2>");
		try {
			mail.SendMail();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
public static void main(String[] args) {
	System.out.println("발송시작");
	EmailSender test = new EmailSender("jjhsnail@gmail.com","1111");
	test.sendGMail();
	System.out.println("발송완료");
}	
	
}
