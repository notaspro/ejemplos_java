package com.gonzasilve.puntoventas.pvcore.dao.impl;

import org.springframework.stereotype.Repository;

import com.gonzasilve.puntoventas.pvcore.dao.BaseDAO;
import com.gonzasilve.puntoventas.pvcore.dao.IUsuarioDao;
import com.gonzasilve.puntoventas.pvmodel.entity.Usuario;

/**
 * <p>
 * This is the implementation of the Usuario DAO. You can see that we don't
 * actually have to implement anything, it is all inherited from GenericDAOImpl
 * through BaseDAO. We just specify the entity type (Usuario) and its identifier
 * type (Long).
 * 
 * <p>
 * The @Repository allows Spring to recognize this as a managed component (so we
 * don't need to specify it in XML) and also tells spring to do DAO exception
 * translation to the Spring exception hierarchy.
 * 
 * @author gonzasilve
 * 
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl extends BaseDAO<Usuario, Integer> implements IUsuarioDao {

}
