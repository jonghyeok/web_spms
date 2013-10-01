package net.bitacademy.java41.controls;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SidebarControl {
	@Autowired ProjectService projectService;
	@Autowired MemberService memberService;
	@RequestMapping("/sidebar")
	public String sidebar(
			HttpSession session, Model model , String email) throws Exception {
		Member member = (Member) session.getAttribute("member");
		//member = authService.getUserInfo(member.getEmail(), member.getPassword());
		member  = memberService.getMember(member.getEmail());
		session.setAttribute("member", member);
	
		
		model.addAttribute("myprojects", 
				projectService.getMyProjects(member.getEmail()));
		return "sidebar";
	}
}







