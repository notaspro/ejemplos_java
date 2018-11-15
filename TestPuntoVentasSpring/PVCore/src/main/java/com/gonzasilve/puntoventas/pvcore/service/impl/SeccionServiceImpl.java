package com.gonzasilve.puntoventas.pvcore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonzasilve.puntoventas.pvcore.dao.ISeccionDao;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.ISearch;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.Search;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.SearchResult;
import com.gonzasilve.puntoventas.pvcore.service.ISeccionService;
import com.gonzasilve.puntoventas.pvmodel.entity.Seccion;

/**
 * This is the implementation for our Seccion Service. The @Service annotation
 * allows Spring to automatically detect this as a component rather than having
 * to comfigure it in XML. The @Autowired annotation tells Spring to inject our
 * Seccion DAO using the setDao() method.
 * 
 * @author gonzasilve
 * 
 */
@Service("seccionService")
@Transactional
public class SeccionServiceImpl implements ISeccionService {

	@Autowired
	ISeccionDao seccionDao;

	public void save(Seccion seccion) {
		seccionDao.save(seccion);
	}
	
	public List<Seccion> findAll() {
		return seccionDao.findAll();
	}

	public Seccion findByName(String name) {
		if (name == null)
			return null;
		return seccionDao.searchUnique(new Search().addFilterEqual(
				"nombreSeccion", name));
	}

	public void flush() {
		seccionDao.flush();
	}

	public List<Seccion> search(ISearch search) {
		return seccionDao.search(search);
	}

	public Seccion findById(Integer idSeccion) {
		return seccionDao.find(idSeccion);
	}

	public void delete(Integer idSeccion) {
		seccionDao.removeById(idSeccion);
	}

	public SearchResult<Seccion> searchAndCount(ISearch search) {
		return seccionDao.searchAndCount(search);
	}
	
	@Override
	public List<Seccion> searchAllAndOrderByColumn(String columnOrder) {
		List<Seccion> result = null;		
		Search s = new Search();
		//s.addField("orden");
		//s.addField("name");
		s.setResultMode(Search.RESULT_AUTO);
		s.addSortAsc(columnOrder);
		result = seccionDao.search(s);
		
		return result;
	}
}
