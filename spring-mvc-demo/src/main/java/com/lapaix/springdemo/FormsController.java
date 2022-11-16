package com.lapaix.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/processFormV2")
	public String processFormVersion2(HttpServletRequest request, Model model) {
		
		String incomingName = request.getParameter("studentName");
		
		String result= "Yo! "+incomingName.toUpperCase();
		model.addAttribute("message" , result);
		
		return "result2";
	}
}
