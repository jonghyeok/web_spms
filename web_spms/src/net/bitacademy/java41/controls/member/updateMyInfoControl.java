package net.bitacademy.java41.controls.member;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;

public class updateMyInfoControl implements PageControl {
	
	MemberService memberService;
	
	public updateMyInfoControl setMemberService(MemberService memberService) {
		this.memberService = memberService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 	(Map<String,String[]>)model.get("params");
		
		
		Member member = memberService.getMember(params.get("email")[0]);
		
		System.out.println(member.getEmail());
		
		String pwd = params.get("password")[0]; 
		
		System.out.println(pwd + "  -   " + member.getPassword());
		if(pwd.equals(null)){
			model.put("status", "pwdnull");
			
			
		}else if(pwd.equals(member.getPassword())){
			
			String name = params.get("name")[0];
			String tel = params.get("tel")[0];
			String blog = params.get("blog")[0];
			String detailAddress = null;
			String tag = null;
			String email = member.getEmail();
			int level = member.getLevel();
/*
			if(params.get("blog")[0] == null){
				blog="";
			}else{
				
				blog = params.get("blog")[0];
			}
			
			if(params.get("detailAddress")[0] == null){
				detailAddress="";
			}else{
				detailAddress=params.get("detailAddress")[0];
			}
			
			if(params.get("tag")[0] == null){
				tag="";
			}else{
				tag=params.get("tag")[0];
			}*/
			
			
			memberService.memberUpdate(name, tel, blog, detailAddress, tag, email, level);
			model.put("status", "SUCCESS");
			
		}else{
			model.put("status", "longpwd");
		}
		

		return "/member/UpdateResult.jsp";
	}
	
	
	
	
	
			


}

