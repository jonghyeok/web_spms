package net.bitacademy.java41.controls;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.services.AuthService;
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
	@Autowired AuthService authService;
	@RequestMapping("/sidebar")
	public String sidebar(
			HttpSession session, Model model , String email) throws Exception {
		Member member = (Member) session.getAttribute("member");
		//member = authService.getUserInfo(member.getEmail(), member.getPassword());
		member  = memberService.getMember(member.getEmail());
		session.setAttribute("member", member);
		System.out.println("앞");
		System.out.println(member.getEmail());
		System.out.println(member.getPassword());
		System.out.println("레빌"+member.getLevel());
		System.out.println("뒤");
		
		model.addAttribute("myprojects", 
				projectService.getMyProjects(member.getEmail()));
		return "/sidebar.jsp";
	}
}







