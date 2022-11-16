package com.lapaix.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/fun")
public class FormsController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "basicForm";
	}
	
	// V1
	@RequestMapping("/processForm")
	public String processForm() {
		return "resultForm";
	}
	
	// V2
	@RequestMapping("/processFormV2")
	public String processFormVersion2(HttpServletRequest request, Model model) {
		
		String incomingName = request.getParameter("studentName");
		
		String result= "Yo! "+incomingName.toUpperCase();
		model.addAttribute("message" , result);
		
		return "resultV2";
	}
	
	// V3 : Binding parameters to the variables
	@RequestMapping("/processFormV3")
	public String processFormVersion3(@RequestParam("studentName") String theName, Model model) {
		
		String result= "Yo! "+theName.toUpperCase();
		model.addAttribute("message" , result);
		
		return "resultV3";	
	}
}
