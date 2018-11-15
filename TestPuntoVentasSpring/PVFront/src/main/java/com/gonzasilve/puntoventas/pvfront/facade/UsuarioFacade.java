package com.gonzasilve.puntoventas.pvfront.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gonzasilve.puntoventas.pvcore.service.IUsuarioService;
import com.gonzasilve.puntoventas.pvmodel.entity.Usuario;

/**
 * Clase que implementa el patron Facade para concentrar operaciones
 * relacionadas con los Usuarios.
 * Date: 21-08-2014
 * 
 * @author gonzasilve
 *
 */
@Component("usuarioFacade")
public class UsuarioFacade {

	@Autowired
	IUsuarioService usuarioService;
	
	/**
	 * Devuelve una entidad {@link com.gonzasilve.puntoventas.pvmodel.entity.Usuario Usuario} en base
	 * al Id que llega como parametro
	 * @param idUser	Id del usuario que se desea recuperar
	 * @return
	 * <ul>
	 * 	<li>Una entidad {@link com.gonzasilve.puntoventas.pvmodel.entity.Usuario Usuario}</li>
	 * 	<li>null En caso de no encontrar ningun usuario con el Id indicado</li>
	 * </ul>
	 */
	public Usuario findById(Integer idUser) {
		return usuarioService.findById(idUser);
	}
}
