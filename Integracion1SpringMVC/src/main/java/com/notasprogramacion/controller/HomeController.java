package com.notasprogramacion.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.notasprogramacion.dto.UsuarioDto;

@Controller
public class HomeController {

	@Value("${app.urlhome}")
	private String urlHomeFront;
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Hola Mundo Spring MVC");
		model.addAttribute("usuario", new UsuarioDto(1, "Gonzalo Silverio"));
		model.addAttribute("urlHome", urlHomeFront);
		
		return "home";
	}
}