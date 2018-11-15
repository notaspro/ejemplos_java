package com.gonzasilve.puntoventas.pvcore.dao;

import com.gonzasilve.puntoventas.pvcore.dao.hibernate.IGenericDAO;
import com.gonzasilve.puntoventas.pvmodel.entity.Usuario;


/**
 * <p>
 * Interface for the Usuario DAO. This is created very simply by extending
 * GenericDAO and specifying the type for the entity class (Usuario) and the
 * type of its identifier (Integer).
 * 
 * <p>
 * As a matter of best practice other components reference this interface rather
 * than the implementation of the DAO itself.
 * 
 * @author gonzasilve
 * 
 */
public interface IUsuarioDao extends IGenericDAO<Usuario, Integer> {

}
