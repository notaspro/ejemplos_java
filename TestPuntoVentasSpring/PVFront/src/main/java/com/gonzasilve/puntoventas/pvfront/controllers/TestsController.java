package com.gonzasilve.puntoventas.pvfront.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gonzasilve.puntoventas.pvcore.dto.UserDto;
import com.gonzasilve.puntoventas.pvcore.service.IUsuarioService;
import com.gonzasilve.puntoventas.pvcore.utils.PvCoreUtils;
import com.gonzasilve.puntoventas.pvmodel.entity.Usuario;

@Controller
@RequestMapping(value="/tests")
//@SessionAttributes("user")
public class TestsController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	IUsuarioService usuarioService;
	
	
	/** 
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/QueryUI", method = RequestMethod.GET)
	public String testJQueryUI(Model model) {
		logger.info("prueba con JQuery jquery-ui-1.10.3");

		return "tests/testJQueryUI";
	}

	
}
