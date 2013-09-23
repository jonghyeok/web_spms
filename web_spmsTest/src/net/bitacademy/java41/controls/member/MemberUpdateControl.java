package net.bitacademy.java41.controls.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;

@Component("/member/update2.do")
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
	
	String email = params.get("email")[0];
	System.out.println(email);
	Member member = memberService.getMember(params.get("email")[0]);
	
	String name=member.getName();
	String tel=member.getTel();
	String blog=member.getBlog();
	String detailAddress=member.getDetailAddress();
	String tag=member.getTag();
	int level=member.getLevel();
	
	if(params.get("blog")[0]==null & params.get("blog")[0]==""){
		blog="";
	}else{
		blog=params.get("blog")[0];
	}
	
	if(params.get("tel")[0]==null & params.get("tel")[0]==""){
		tel="";
	}else{
		blog=params.get("tel")[0];
	}
	System.out.println(params.get("detailAddress")[0]);
	if(params.get("detailAddress")[0]==null && params.get("detailAddress")[0]==""){
		detailAddress="";
	}else{
	detailAddress=params.get("detailAddress")[0];
	 }
	
	if(params.get("tag")[0]==null & params.get("tag")[0]==""){
		tag="";
	}else{
		blog=params.get("tag")[0];
	}
	
	if(params.get("level")[0]==null & params.get("level")[0]==""){
		level=0;
	}else{
		blog=params.get("level")[0];
	}
	

	model.put("email", member.getEmail());
	
	if (memberService.memberUpdate
			(name, tel, blog, detailAddress, tag, email, level) > 0) {
		model.put("status", "SUCCESS");
	} else if("".equals(name)){
		model.put("status", "FAIL");
	}
	
	
	return "/member/memberUpdateResult.jsp";
}
	

}

