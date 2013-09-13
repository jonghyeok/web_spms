package net.bitacademy.java41.controls.member;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.MemberService;

public class MemberDeleteControl implements PageControl{

	MemberService memberService;
	
	public MemberDeleteControl setMemberService(MemberService memberService) {
		this.memberService = memberService;
		return this;
	}
	


	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		String email = params.get("email")[0];
		
		
		
		if (memberService.delete(email) > 0) {
			model.put("status", "SUCCESS");
			System.out.println("ok");
		} else {
			model.put("status", "FAIL");
			System.out.println("fail");
		}
		
		return "/member/memberDeleteResult.jsp";
	}

	
}
