package com.gonzasilve.puntoventas.pvfront.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gonzasilve.puntoventas.pvcore.dto.SeccionDto;
import com.gonzasilve.puntoventas.pvcore.utils.PvCoreConstants;
import com.gonzasilve.puntoventas.pvmodel.entity.Seccion;

public class PvFrontUtils {


	/**
	 * Convierte el collection de entidades que llega como parametro a un collection de Dtos
	 * @param lstSecciones	Es un Collection con todas las secciones en la BD
	 * @return
	 * <ul>
	 * 	<li>List<SeccionDto></li>
	 * <li>Null si la lista que llega como parametro no tiene items</li>
	 * </ul>
	 */
	public static List<SeccionDto> convertSectionsToDto(List<Seccion> lstSecciones) {
		List<SeccionDto> result = null;
		if(lstSecciones.size()>0) {
			result = new ArrayList<SeccionDto>();
			for(Seccion seccion : lstSecciones) {
				SeccionDto dto = new SeccionDto();
				dto.setIdSeccion(seccion.getIdSeccion());
				dto.setNombreSeccion(seccion.getNombreSeccion());
				dto.setNombreCapa(seccion.getNombreCapa()==null?"":seccion.getNombreCapa());
				dto.setUrlSeccion(seccion.getUrlSeccion()==null?"":seccion.getUrlSeccion());
				dto.setActiva(seccion.getActiva());
				dto.setOrden(seccion.getOrden());
				if(dto.isActive())
					result.add(dto);
			}			
		}

		return result;
	}
	
	/**
	 * Devuelve la tabla de secciones a un HashMap  
	 * @param lstSecciones	Es un Collection con todas las secciones en la BD
	 * @return
	 * <ul>
	 * 	<li>Map<String, String></li>
	 * <li>Null si la lista que llega como parametro no tiene items</li>
	 * </ul>
	 */
	public static Map<String, String> getMapaSecciones(List<SeccionDto> lstSecciones) {
		Map<String, String> result = null;
		if(lstSecciones.size()>0) {
			result = new HashMap<String, String>();
			for(SeccionDto seccion : lstSecciones) {
				if(seccion.isActive())
					result.put(String.valueOf(seccion.getIdSeccion()), seccion.getNombreCapa());				
			}			
		}

		return result;
	}
	
	
	public static String getCapaByIdSeccion(Integer idSeccion) {
		String nombreCapa;
		nombreCapa = PvCoreConstants.SeccionesApp.getSeccionById(idSeccion).getNombreCapaSeccion();
		return nombreCapa;
	}
}