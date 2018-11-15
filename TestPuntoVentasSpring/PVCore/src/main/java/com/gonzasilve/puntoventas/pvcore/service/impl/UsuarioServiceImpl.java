package com.gonzasilve.puntoventas.pvcore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonzasilve.puntoventas.pvcore.dao.IUsuarioDao;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.ISearch;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.Search;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.SearchResult;
import com.gonzasilve.puntoventas.pvcore.service.IUsuarioService;
import com.gonzasilve.puntoventas.pvmodel.entity.Usuario;

/**
 * This is the implementation for our Usuario Service. The @Service annotation
 * allows Spring to automatically detect this as a component rather than having
 * to comfigure it in XML. The @Autowired annotation tells Spring to inject our
 * Usuario DAO using the setDao() method.
 * 
 * @author gonzasilve
 * 
 */
@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioDao usuarioDao;

	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}

	public Usuario findByName(String name) {
		if (name == null)
			return null;
		return usuarioDao.searchUnique(new Search().addFilterEqual("nombre", name));
	}

	public void flush() {
		usuarioDao.flush();
	}

	public List<Usuario> search(ISearch search) {
		return usuarioDao.search(search);
	}

	public Usuario findById(Integer id) {
		return usuarioDao.find(id);
	}

	public void delete(Integer id) {
		usuarioDao.removeById(id);
	}

	public SearchResult<Usuario> searchAndCount(ISearch search) {
		return usuarioDao.searchAndCount(search);
	}
}
