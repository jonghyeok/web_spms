package net.bitacademy.java41.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/AboutUs/AboutUs")
public class AboutUsControl{

	@RequestMapping
	public String execute() throws Exception {
		return "AboutUs/AboutUs";
	}

}












