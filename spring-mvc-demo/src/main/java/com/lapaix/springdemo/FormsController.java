package com.lapaix.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormsController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "basicForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "resultForm";
	}
}
