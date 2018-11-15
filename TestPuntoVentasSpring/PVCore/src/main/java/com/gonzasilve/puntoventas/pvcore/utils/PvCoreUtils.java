package com.gonzasilve.puntoventas.pvcore.utils;

import com.gonzasilve.puntoventas.pvcore.dto.UserDto;
import com.gonzasilve.puntoventas.pvmodel.entity.Usuario;

public class PvCoreUtils {

	public static UserDto getUserDtoFromUserEntity(Usuario usuario) {
		UserDto result = new UserDto();
		if(null==usuario)
			return null;
		
		result.setId_usuario(usuario.getId_usuario());
		result.setNombre(usuario.getNombre());
		result.setApellidoMaterno(usuario.getApellidoMaterno());
		result.setApellidoPaterno(usuario.getApellidoPaterno());		
		result.setEmail(usuario.getEmail());
		Integer idRol = usuario.getRolesUsuario().getIdRol();
		result.setIdRol(idRol);
		
		return result;
	}
	
	public static String getSeccionNameById(Integer idSeccion) {
		return "home";
	}
}
