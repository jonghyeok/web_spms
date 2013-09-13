package net.bitacademy.java41.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;


public class MemberUpdateControl implements PageControl {

	MemberService memberService;
	
	public MemberUpdateControl setMemberService(MemberService memberService) {
		this.memberService = memberService;
		return this;
	}
	

@Override
public String execute(Map<String, Object> model) throws Exception {

	System.out.println("업데이트");
	@SuppressWarnings("unchecked")
	Map<String,String[]> params = 
			(Map<String,String[]>)model.get("params");
	
	HttpSession session = (HttpSession) model.get("session");
	
	Member member = (Member)session.getAttribute("memberInfo");
	
	String email = member.getEmail();
	System.out.println(email);
	String name = params.get("name")[0];
	String tel =params.get("tel")[0];
	String blog = params.get("blog")[0];
	String detailAddress =params.get("detailAddress")[0];
	String tag = params.get("tag")[0];
	int level = Integer.parseInt(params.get("level")[0]);

	if (memberService.memberUpdate
			(name, tel, blog, detailAddress, tag, email, level) > 0) {
		model.put("status", "SUCCESS");
	} else if("".equals(name)){
		model.put("status", "FAIL");
	}
	
	
	return "/member/memberUpdateResult.jsp";
}
	

}

