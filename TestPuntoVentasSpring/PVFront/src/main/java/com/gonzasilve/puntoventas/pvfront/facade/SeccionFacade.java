package com.gonzasilve.puntoventas.pvfront.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gonzasilve.puntoventas.pvcore.service.ISeccionService;
import com.gonzasilve.puntoventas.pvmodel.entity.Seccion;

/**
 * Clase que implementa el patron Facade para concentrar operaciones
 * relacionadas con las secciones.
 * Date: 21-08-2014
 * 
 * @author gonzasilve
 *
 */
@Component("seccionFacade")
public class SeccionFacade{

	@Autowired
	ISeccionService seccionService;
	
	/**
	 * Devuelve una entidad {@link com.gonzasilve.puntoventas.pvmodel.entity.Seccion Seccion} en base
	 * al Id que llega como parametro
	 * @param idUser	Id de la seccion que se desea recuperar
	 * @return
	 * <ul>
	 * 	<li>Una entidad {@link com.gonzasilve.puntoventas.pvmodel.entity.Seccion Seccion}</li>
	 * 	<li>null En caso de no encontrar ningun seccion con el Id indicado</li>
	 * </ul>
	 */
	public Seccion findById(Integer idSeccion) {
		return seccionService.findById(idSeccion);
	}
	
	/**
	 * Devuelve todas las entidades {@link com.gonzasilve.puntoventas.pvmodel.entity.Seccion Seccion} en la base
	 * 
	 * @return
	 * <ul>
	 * 	<li>Un collection de entidades {@link com.gonzasilve.puntoventas.pvmodel.entity.Seccion Seccion}</li>
	 * 	<li>null En caso de no encontrar ninguna seccion en la bd</li>
	 * </ul>
	 */
	public List<Seccion> findAll() {
		return seccionService.findAll();
	}
	

	/**
	 * Hace una busqueda de todas las entidades {@link com.gonzasilve.puntoventas.pvmodel.entity.Seccion Seccion} en la base
	 * y las ordena por la columna que llega como parametro
	 * 
	 * @param columnOrder	Columna por la que se ordenaran los resultados
	 * @return
	 * <ul>
	 * 	<li><b>Un collection</b> de entidades {@link com.gonzasilve.puntoventas.pvmodel.entity.Seccion Seccion}</li>
	 * 	<li><b>null</b> En caso de no encontrar ninguna seccion en la bd</li>
	 * </ul>
	 */
	public List<Seccion> searchAndOrder(String columnOrder) {
		return seccionService.searchAllAndOrderByColumn(columnOrder);
	}
}
