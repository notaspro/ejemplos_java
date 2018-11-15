package com.gonzasilve.puntoventas.pvfront.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gonzasilve.puntoventas.pvcore.dto.SeccionDto;
import com.gonzasilve.puntoventas.pvcore.dto.UserDto;
import com.gonzasilve.puntoventas.pvcore.utils.PvCoreConstants.SeccionesApp;
import com.gonzasilve.puntoventas.pvfront.utils.PvFrontUtils;

/**
 * Controlador para mapear y manejar todas las URL
 * relacionadas con los empleados
 * 
 * @author gonzasilve
 * 
 * Date: 22-09-2014
 */
@Controller
@RequestMapping(value = "empleados")
@SessionAttributes(value={"user"})
public class EmpleadosController {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadosController.class);
	
	
	@Value("${pvcore.app.urlhome}")
	private String urlHomeCore="";

	/** 
	 * Renderiza la vista empleados. Al insertar un objeto HttpSession session en un metodo  
	 * de un controlador,  spring automaticamente inyecta la sesion actual en este objeto
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String vistaHome(Model model, @ModelAttribute("user") UserDto user, HttpSession session ) {
		logger.info("Vista Empleados");

		List<SeccionDto> lstSecciones = (List<SeccionDto>)session.getAttribute("secciones");
		
		//Aqui en base a si el usuario es admin se pueden filtrar las secciones a las que puede ver
		//Teoricamente las secciones se deben cargar al hacer login y restringirse desde ese momento 
		//dependiendo del tipo de usuario
		//user.isAdmin()
		
		//Quitamos la seccion TODAS
		Iterator<SeccionDto> iterador = lstSecciones.iterator();
		while(iterador.hasNext()) {
			SeccionDto s = iterador.next();
			//System.out.println(s);
			SeccionesApp sec = SeccionesApp.getSeccionById(s.getIdSeccion());
			if(sec.equals(SeccionesApp.ALL_SECTIONS)) {
				iterador.remove();
			}
		}
			

		Map<String, String> mapaSecciones = PvFrontUtils.getMapaSecciones(lstSecciones);
		
		model.addAttribute("idSeccion",SeccionesApp.EMPLEADOS.getIdSeccion());
		model.addAttribute("mapaSecciones", mapaSecciones );
		return "sections/empleados/empleados";
	}
}
