package net.bitacademy.java41.controls.member;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member")
public class MemberControl {
	@Autowired ServletContext sc;
	@Autowired MemberService memberService;
	long currTime = 0;
	int count = 0;

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupForm() {
		System.out.println("dasdasd");
		return "/member/signupForm.jsp";
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(
			Member member,
			MultipartFile photo,
			HttpSession session){
		try{
			String filename = this.getNewFileName();
			String path = sc.getAttribute("rootRealPath") + "file/" + filename;
			photo.transferTo(new File(path));
			member.setPhotos(new String[]{filename});

			memberService.signUp(member);
			session.setAttribute("member", member);

			return "redirect:../main.do";
		}catch(Exception e){
			return "/error.jsp";
		}
	}

	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", memberService.getMemberList());
		return "/member/list.jsp";
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String form() {
		return "/member/newForm.jsp";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Member member, MultipartFile photo , Model model) throws Exception {

		String filename = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + filename;
		photo.transferTo(new File(path));
		member.setPhotos(new String[]{filename});
		try{
			memberService.signUp(member);

			return "redirect:list.do";
		}catch(Exception e){
			model.addAttribute("status", "ADD_FAIL");
				
			return "/member/UpdateResult.jsp";
		}
	}

	@RequestMapping("/view")
	public String view(String email, Model model) throws Exception {
		model.addAttribute("memberInfo", memberService.getMember(email));
		return "/member/view.jsp";
	}

	@RequestMapping(value="/passwordChange", method=RequestMethod.GET)
	public String passwordForm() {

		return "/member/passwordForm.jsp";
	}

	@RequestMapping(value="/passwordChange", method=RequestMethod.POST)
	public String changePassword(
			String email, 
			@RequestParam("password") String password, 
			String newPassword, String newPassword2,
			Model model)
					throws Exception {
		System.out.println(password);
		System.out.println(newPassword);
		if (newPassword.equals(newPassword2)) {
			if (memberService.changePassword(email, password, newPassword)) {
				model.addAttribute("status", "SUCCESS");
			} else {
				model.addAttribute("status", "OLD_PASSWORD_ERROR");
			}
		} else {
			model.addAttribute("status", "NEW_PASSWORD_ERROR");
		}
		return "/member/passwordChangeResult.jsp";
	}

	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateForm(String email, Model model) throws Exception {
		model.addAttribute("memberInfo", memberService.getMember(email));
		return "/member/updateForm.jsp";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Member member, MultipartFile photo ) throws Exception {

		if(photo.getSize()>0){ //업데이트할때 사진 선택시
			String filename = this.getNewFileName();
			String path = sc.getAttribute("rootRealPath") + "file/" + filename;
			photo.transferTo(new File(path));
			member.setPhotos(new String[]{filename});
		}
		memberService.updateMember(member);


		return "redirect:view.do?email=" + member.getEmail();

	}

	@RequestMapping("/delete")
	public String delete(String email) throws Exception {
		memberService.deleteMember(email);
		return "redirect:list.do";
	}

	synchronized private String getNewFileName() {
		long millis = System.currentTimeMillis(); //1000
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "member_" + millis + "_" + (++count);
	}
	@RequestMapping(value="/updateMyInfo",method=RequestMethod.GET)
	public String updateMyInfo(Member member, Model model, HttpSession session) throws Exception {

		model.addAttribute("member", memberService.getMember(member.getEmail()));
		return "/member/updateMyInfoForm.jsp";
	}


	@RequestMapping(value="/updateMyInfo",method=RequestMethod.POST)
	public String update(
			String serverpwd,
			Member member,
			MultipartFile photo,
			Model model) throws Exception {

		if(serverpwd.equals(member.getPassword())){
			if(photo.getSize()>0){ //업데이트할때 사진 선택시
				String filename = this.getNewFileName();
				String path = sc.getAttribute("rootRealPath") + "file/" + filename;
				photo.transferTo(new File(path));
				member.setPhotos(new String[]{filename});
			}
			memberService.updateMember(member);
			model.addAttribute("status", "SUCCESS");

		}else{
			System.out.println(member.getPassword());
			model.addAttribute("status", "OLD_PASSWORD_ERROR");

		}
		return "/member/UpdateResult.jsp";
	}
}













