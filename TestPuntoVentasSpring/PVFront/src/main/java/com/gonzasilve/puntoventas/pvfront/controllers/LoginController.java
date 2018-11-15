package com.gonzasilve.puntoventas.pvfront.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String goLogin(){
		return "security/login";
	}
	
	@RequestMapping(value="/failLogin", method=RequestMethod.GET)
	public String failedLogin(ModelMap model){		
		model.addAttribute("error", "true");
		return "security/login";
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoff(ModelMap model){
		return "security/logout";
	}
	

}