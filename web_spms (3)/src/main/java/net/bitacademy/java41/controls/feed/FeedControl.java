package net.bitacademy.java41.controls.feed;

import java.util.List;

import net.bitacademy.java41.services.FeedService;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Feed;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/feed")
public class FeedControl {
	@Autowired FeedService feedService;
	@Autowired MemberService memberService;

	@RequestMapping(value="list",method=RequestMethod.GET)
	public String list(int pno,Model model) throws Exception {
		
		List<Feed> feeds = feedService.listFeed(pno) ;
		
		Member member = null;
		for(Feed feed : feeds){
			member = memberService.getMember(feed.getEmail());
			feed.setPhotos(member.getPhotos());
			model.addAttribute(feed.getEmail(),feed.getPhotos()[0]);
		}
		
		model.addAttribute("list", feeds );
		
		model.addAttribute("pno",pno);
		System.out.println("feed 보기  pno값은.." + pno);
		return "feed/feed";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(Feed feed,Model model) throws Exception {
		try{
		feedService.addFeed(feed);
		return "redirect:list.do?pno="+feed.getPno();
		}catch(Exception e){
			return "redirect:list.do?pno="+feed.getPno();
		}
	}

	
	@RequestMapping("/delete")
	public String delete(int fno,int pno) throws Exception {
		feedService.deleteFeed(fno);
		return "redirect:list.do?pno="+pno;
		}

	/*
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateForm(int no, Model model) throws Exception {
		model.addAttribute("project", projectService.getProject(no));
		return "/project/projectUpdate";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Project project) throws Exception {
		projectService.updateProject(project);
		return "redirect:view.do?no=" + project.getNo();
	}
	*/
	
	
	
}













