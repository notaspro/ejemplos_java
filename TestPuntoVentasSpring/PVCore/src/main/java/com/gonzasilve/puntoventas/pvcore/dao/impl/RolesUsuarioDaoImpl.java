package com.gonzasilve.puntoventas.pvcore.dao.impl;

import org.springframework.stereotype.Repository;

import com.gonzasilve.puntoventas.pvcore.dao.BaseDAO;
import com.gonzasilve.puntoventas.pvcore.dao.IRolesUsuarioDao;
import com.gonzasilve.puntoventas.pvmodel.entity.RolesUsuario;


/**
 * <p>
 * This is the implementation of the RolesUsuario DAO. You can see that we don't
 * actually have to implement anything, it is all inherited from GenericDAOImpl
 * through BaseDAO. We just specify the entity type (RolesUsuario) and its identifier
 * type (Integer).
 * 
 * <p>
 * The @Repository allows Spring to recognize this as a managed component (so we
 * don't need to specify it in XML) and also tells spring to do DAO exception
 * translation to the Spring exception hierarchy.
 * 
 * @author gonzasilve
 * 
 */
@Repository("rolesUsuarioDao")
public class RolesUsuarioDaoImpl extends BaseDAO<RolesUsuario, Integer> implements IRolesUsuarioDao {

}
