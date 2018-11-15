package com.notasprogramacion.springboot.security.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogginController {

	private static final Log LOG = LogFactory.getLog(LogginController.class);
	private static final String LOGIN_VIEW = "loginForm";
	private static final String LOGIN_HOME = "home";
	
	@GetMapping("/login")
	public String logginHome(Model model,
			@RequestParam(name="error", required = false) String error,
			@RequestParam(name="logout", required = false) String logout) {
		LOG.info("Calling method LogginController.logginHome()...");
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		
		return LOGIN_VIEW;
	}
	
	//@PreAuthorize("hasRole('USER_ROLE') or hasRole('ADMIN_ROLE')")
	@GetMapping({"/loginsuccess", "/"})
	public String loginsuccess(Model model) {
		LOG.info("Calling method LogginController.loginsuccess()...");
		User usr = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username", usr.getUsername());
		return LOGIN_HOME;
	}
}
