package com.gonzasilve.puntoventas.pvcore.service;

import java.util.List;

import com.gonzasilve.puntoventas.pvcore.dao.hibernate.ISearch;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.SearchResult;
import com.gonzasilve.puntoventas.pvmodel.entity.Seccion;

/**
 * This is the interface for our Seccion Service. As a matter of best practice
 * we reference this interface in other components rather than the
 * implementation itself.
 * 
 * @author gonzasilve
 * 
 */
public interface ISeccionService {

	public void save(Seccion seccion);

	public void delete(Integer idSeccion);

	public List<Seccion> findAll();

	public List<Seccion> search(ISearch search);

	public SearchResult<Seccion> searchAndCount(ISearch search);

	public Seccion findById(Integer idSeccion);

	public Seccion findByName(String name);

	public void flush();
	
	public List<Seccion> searchAllAndOrderByColumn(String columnOrder);
}