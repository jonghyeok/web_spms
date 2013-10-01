package net.bitacademy.java41.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/News/NotePage")
public class NotePageControl{

	@RequestMapping
	public String execute() throws Exception {
		return "News/NotePage";
	}

}












