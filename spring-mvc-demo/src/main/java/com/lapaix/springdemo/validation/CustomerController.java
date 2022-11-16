package com.lapaix.springdemo.validation;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("form")
	public String showPage(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "customerForm";
	}
	
	@RequestMapping("/processForm")
	public String processTheForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
			
//		System.out.println("Last name: "+ theCustomer.getLastName());
		
		if(theBindingResult.hasErrors()) {
			return "customerForm";
		}
		else {
			return "customer-confirmation";
		}
	}
}
