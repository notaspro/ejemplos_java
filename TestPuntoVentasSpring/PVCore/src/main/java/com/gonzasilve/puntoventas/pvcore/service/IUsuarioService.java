package com.gonzasilve.puntoventas.pvcore.service;


import java.util.List;

import com.gonzasilve.puntoventas.pvcore.dao.hibernate.ISearch;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.SearchResult;
import com.gonzasilve.puntoventas.pvmodel.entity.Usuario;

/**
 * This is the interface for our Usuario Service. As a matter of best practice
 * we reference this interface in other components rather than the
 * implementation itself.
 * 
 * @author gonzasilve
 * 
 */
public interface IUsuarioService {

	public void save(Usuario usuario);

	public void delete(Integer id);

	public List<Usuario> findAll();

	public List<Usuario> search(ISearch search);

	public SearchResult<Usuario> searchAndCount(ISearch search);

	public Usuario findById(Integer id);

	public Usuario findByName(String name);

	public void flush();
}