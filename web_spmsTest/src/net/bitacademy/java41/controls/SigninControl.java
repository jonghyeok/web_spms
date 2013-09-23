package net.bitacademy.java41.controls;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;
@Component("/member/signin.do")
public class SigninControl implements PageControl {
	String rootRealPath;
	MemberService memberService;
	long currTime = 0;
	int count = 0;

	public void setRootRealPath(String rootRealPath) {
		this.rootRealPath = rootRealPath;
	}

	public SigninControl setMemberService(MemberService memberService) {
		this.memberService = memberService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,Object> params = 
		(Map<String,Object>)model.get("params");

		
		
		Member member = new Member()
		.setEmail((String)params.get("email"))
		.setName((String)params.get("name"))
		.setPassword((String)params.get("password"))
		.setTel((String)params.get("tel"))
		.setBlog((String)params.get("blog"))
		.setDetailAddress((String)params.get("detailAddr"))
		.setTag((String)params.get("tag"));

		if(params.get("photo")!=null){
			FileItem photo = (FileItem)params.get("photo");
			String filename = this.getNewFileName();
			String path = rootRealPath + "file/" + filename;
			photo.write(new File(path));
			member.setPhotos(new String[]{filename});
			
		}else{
			String[] filename = (String[]) params.get("photo");
			member.setPhotos(filename);
		}


		memberService.signUp(member);

		HttpSession session = (HttpSession)model.get("session");
		session.setAttribute("member", member);

		return "redirect:../main.do";
	}

	synchronized private String getNewFileName() {
		long millis = System.currentTimeMillis();
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "member_" + millis + "_" + (++count);
	}
}










