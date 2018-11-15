package com.gonzasilve.puntoventas.pvfront.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gonzasilve.puntoventas.pvcore.dao.hibernate.Search;
import com.gonzasilve.puntoventas.pvcore.dto.SeccionDto;
import com.gonzasilve.puntoventas.pvcore.dto.UserDto;
import com.gonzasilve.puntoventas.pvcore.utils.PvCoreConstants.SeccionesApp;
import com.gonzasilve.puntoventas.pvcore.utils.PvCoreUtils;
import com.gonzasilve.puntoventas.pvfront.facade.SeccionFacade;
import com.gonzasilve.puntoventas.pvfront.facade.UsuarioFacade;
import com.gonzasilve.puntoventas.pvfront.utils.PvFrontUtils;
import com.gonzasilve.puntoventas.pvmodel.entity.Seccion;
import com.gonzasilve.puntoventas.pvmodel.entity.Usuario;

/**
 * Controlador para maneja todos los request para la pagina de inicio
 * 
 * @author gonzasilve
 * 
 * Date: 10-07-2014
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UsuarioFacade usuarioFacade;
	
	@Autowired
	private SeccionFacade seccionFacade;
	
	private static List<MessageForm> messageFormRepository = new ArrayList<MessageForm>();
	
	
	@Value("${pvcore.app.urlhome}")
	private String urlHomeCore="";

	/** 
	 * Renderiza la vista home
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String vistaHome(Model model, @ModelAttribute("user") UserDto user, HttpServletRequest request ) {
		logger.info("Vista home");

		//-------------------------------------------------------------------
		//Test Hard-Code for logged user
		//-------------------------------------------------------------------
		Usuario usuario = usuarioFacade.findById(1); 
		UserDto usr =  PvCoreUtils.getUserDtoFromUserEntity(usuario);
		System.out.println("isAdmin(): "+usr.isAdmin());
		
		HttpSession sesion = request.getSession(true);
		List<Seccion> secciones = seccionFacade.searchAndOrder("orden");
		

		
		//Aqui en base a si el usuario es admin se pueden filtrar las secciones a las que puede ver
		//Teoricamente las secciones se deben cargar al hacer login y restringirse desde ese momento 
		//dependiendo del tipo de usuario
		//user.isAdmin()
		
		//Quitamos la seccion TODAS
		List<SeccionDto> lstSecciones = PvFrontUtils.convertSectionsToDto(secciones);
		Iterator<SeccionDto> iterador = lstSecciones.iterator();
		while(iterador.hasNext()) {
			SeccionDto s = iterador.next();
			//System.out.println(s);
			SeccionesApp sec = SeccionesApp.getSeccionById(s.getIdSeccion());
			if(sec.equals(SeccionesApp.ALL_SECTIONS)) {
				iterador.remove();
			}

		}
			
		
		
		//SeccionesApp seccion = SeccionesApp.HOME;

		
		Map<String, String> mapaSecciones = PvFrontUtils.getMapaSecciones(lstSecciones);
		
		model.addAttribute("idSeccion",SeccionesApp.HOME.getIdSeccion());
		model.addAttribute("user",usr);
		sesion.setAttribute("user", usr );
		model.addAttribute("mapaSecciones", mapaSecciones );
		sesion.setAttribute("secciones", lstSecciones );
		
		return "sections/home/home";
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String testThymeleaf(Model model) {
		logger.info("Welcome home! from Thymeleaf");

		model.addAttribute("messageInfo", new MessageForm());
		logger.info("URL Home del Modulo Core: "+urlHomeCore);
		
		return "index";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("messageInfo") MessageForm messageForm,	BindingResult result) {

		if (result.hasErrors()) {
			return "index";
		}
		
		logger.info("Se insertara el nuevo mensaje: \n"+messageForm.getMessage());
		addNewMessage(messageForm);
		return "redirect:/list";

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showResults() {
		
		logger.info("Listar Mensajes!...");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		modelAndView.addObject("messages", messageFormRepository);

		return modelAndView;

	}
	
	private void addNewMessage(MessageForm messageForm) {
		messageFormRepository.add(messageForm);
	}

}
