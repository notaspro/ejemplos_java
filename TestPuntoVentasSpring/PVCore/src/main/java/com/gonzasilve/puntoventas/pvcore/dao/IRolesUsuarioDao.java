package com.gonzasilve.puntoventas.pvcore.dao;

import com.gonzasilve.puntoventas.pvcore.dao.hibernate.IGenericDAO;
import com.gonzasilve.puntoventas.pvmodel.entity.RolesUsuario;

/**
 * <p>
 * Interface for the RolesUsuario DAO. This is created very simply by extending
 * GenericDAO and specifying the type for the entity class (RolesUsuario) and the
 * type of its identifier (Integer).
 * 
 * <p>
 * As a matter of best practice other components reference this interface rather
 * than the implementation of the DAO itself.
 * 
 * @author gonzasilve
 * 
 */
public interface IRolesUsuarioDao extends IGenericDAO<RolesUsuario, Integer> {

}
