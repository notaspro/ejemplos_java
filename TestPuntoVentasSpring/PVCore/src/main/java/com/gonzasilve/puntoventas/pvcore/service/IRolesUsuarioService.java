package com.gonzasilve.puntoventas.pvcore.service;

import java.util.List;

import com.gonzasilve.puntoventas.pvcore.dao.hibernate.ISearch;
import com.gonzasilve.puntoventas.pvcore.dao.hibernate.SearchResult;
import com.gonzasilve.puntoventas.pvmodel.entity.RolesUsuario;

/**
 * This is the interface for our RolesUsuario Service. As a matter of best practice
 * we reference this interface in other components rather than the
 * implementation itself.
 * 
 * @author gonzasilve
 * 
 */
public interface IRolesUsuarioService {

	public List<RolesUsuario> findAll();

	/**
	 * Obtiene un rol por su descripcion, no es sensi-case
	 * @param desc Descripci&oacute;n del rol
	 * @return 
	 * <ul>
	 * 		<li><b>Una entidad</b> {@link com.gonzasilve.puntoventas.pvmodel.entity.RolesUsuario RolesUsuario}}</li>
	 * 		<li><b>null</b> si no existe ningun rol con la descripcion especificada</li>
	 * </ul>
	 * 
	 */
	public RolesUsuario findByName(String desc);

	public RolesUsuario findById(Integer id);

	/**
	 * <b>Difference between commit and flush in Hibernate</b> <br/><br/>
	 * 
	 * Flushing the Session simply gets the data that is currently in the session synchronized <br/>
	 * with what is in the database. However, just because you have flushed, doesn't mean the  <br/>
	 * data can't be rolled back. <br/> <br/>
	 * Flushing is the process of synchronizing the underlying persistent store with persistable state held in memory. <br/> <br/>
	 * 
	 * Commit does flush the session, but it also ends the unit of work. <br/> <br/>
	 * 
	 * A database transaction is a unit of work performed against a database management system or <br/> 
	 * similar system that is treated in a coherent and reliable way independent of other transactions. <br/>
	 * A database transaction, by definition, must be atomic, consistent, isolated and durable.  <br/>
	 * These properties of database transactions are often referred to by the acronym ACID.  <br/>
	 * 
	 */
	public void flush();
	
	public void save(RolesUsuario rolesUsuario);

	public void delete(Integer id);

	public List<RolesUsuario> search(ISearch search);

	public SearchResult<RolesUsuario> searchAndCount(ISearch search);

}
