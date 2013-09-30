package net.bitacademy.java41.controls.member;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("member")
@RequestMapping("/member")
public class MemberControl {
	@Autowired ServletContext sc;
	@Autowired MemberService memberService;
	long currTime = 0;
	int count = 0;

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupForm() {
		System.out.println("dasdasd");
		return "member/signupForm";
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(
			Member member,
			MultipartFile photo,
			Model model){
		try{
			String filename = this.getNewFileName();
			String path = sc.getAttribute("rootRealPath") + "file/" + filename;
			photo.transferTo(new File(path));
			member.setPhotos(new String[]{filename});

			memberService.signUp(member);
			model.addAttribute("member", member);

			return "redirect:../main.do";
		}catch(Exception e){
			return "error";
		}
	}

	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", memberService.getMemberList());
		return "member/list";
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String form() {
		return "member/newForm";
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
				
			return "member/UpdateResult";
		}
	}

	@RequestMapping("/view")
	public String view(String email, Model model) throws Exception {
		model.addAttribute("memberInfo", memberService.getMember(email));
		return "member/view";
	}

	@RequestMapping(value="/passwordChange", method=RequestMethod.GET)
	public String passwordForm() {

		return "member/passwordForm";
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
		return "member/passwordChangeResult";
	}

	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateForm(String email, Model model) throws Exception {
		model.addAttribute("memberInfo", memberService.getMember(email));
		return "member/updateForm";
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
		return "member/updateMyInfoForm";
	}



	@RequestMapping(value="/updateMyInfo",method=RequestMethod.POST)
	public String update(
			String kemail,
			String serverpwd,
			Member memberInfo,
			MultipartFile photo,
			@ModelAttribute("member") Member member,
			SessionStatus status,
			Model model) throws Exception {

		if(serverpwd.equals(memberInfo.getPassword())){
			if(photo.getSize()>0){ //업데이트할때 사진 선택시
				String filename = this.getNewFileName();
				String path = sc.getAttribute("rootRealPath") + "file/" + filename;
				photo.transferTo(new File(path));
				memberInfo.setPhotos(new String[]{filename});
			}
			memberService.updateMember(memberInfo);
			
			member = memberService.getMember(kemail);
			
			status.setComplete();
			
			System.out.println("daasdas" + kemail);
			
			model.addAttribute("member",member);
			model.addAttribute("status", "SUCCESS");

		}else{
			System.out.println(memberInfo.getPassword());
			model.addAttribute("status", "OLD_PASSWORD_ERROR");

		}
		return "member/UpdateResult";
	}
}













