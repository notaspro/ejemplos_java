package com.gonzasilve.puntoventas.pvcore.service.impl;

import java.lang.annotation.Inherited;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gonzasilve.puntoventas.pvcore.dao.IRolesUsuarioDao;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.ISearch;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.Search;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.SearchResult;
import com.gonzasilve.puntoventas.pvcore.service.IRolesUsuarioService;
import com.gonzasilve.puntoventas.pvmodel.entity.RolesUsuario;

/**
 * This is the implementation for our RolesUsuario Service. The @Service annotation
 * allows Spring to automatically detect this as a component rather than having
 * to comfigure it in XML. The @Autowired annotation tells Spring to inject our
 * RolesUsuario DAO using the setDao() method.
 * 
 * @author gonzasilve
 * 
 */
@Service("rolesUsuarioService")
@Transactional
public class RolesUsuarioServiceImpl implements IRolesUsuarioService {

	@Autowired
	IRolesUsuarioDao rolesUsuarioDao;
	
	@Transactional
	public void save(RolesUsuario rolesUsuario) {
		boolean res = rolesUsuarioDao.save(rolesUsuario);
		System.out.println("resultado save(): "+res);
	}
	
	public List<RolesUsuario> findAll() {
		return rolesUsuarioDao.findAll();
	}

	public RolesUsuario findByName(String descRol) {
		if (descRol == null)
			return null;
		return rolesUsuarioDao.searchUnique(new Search().addFilterEqual("descRolUsuario", descRol));
	}

	public List<RolesUsuario> search(ISearch search) {
		return rolesUsuarioDao.search(search);
	}

	public RolesUsuario findById(Integer id) {
		return rolesUsuarioDao.find(id);
	}

	public void delete(Integer id) {
		rolesUsuarioDao.removeById(id);
	}

	public SearchResult<RolesUsuario> searchAndCount(ISearch search) {
		return rolesUsuarioDao.searchAndCount(search);
	}

	public void flush() {
		rolesUsuarioDao.flush();
	}
	
}
