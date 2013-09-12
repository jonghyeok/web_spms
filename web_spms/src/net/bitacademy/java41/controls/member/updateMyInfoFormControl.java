package net.bitacademy.java41.controls.member;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.vo.Member;

public class updateMyInfoFormControl implements PageControl {
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Member member = (Member)model.get("member");
		model.put("member", member);
		return "/member/updateForm.jsp";
	}
	
	


	

}

