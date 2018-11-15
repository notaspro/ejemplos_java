package com.gonzasilve.puntoventas.pvcore.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gonzasilve.puntoventas.pvcore.service.IRolesUsuarioService;
import com.gonzasilve.puntoventas.pvmodel.entity.RolesUsuario;
import com.gonzasilve.puntoventas.pvmodel.entity.Usuario;

import static org.junit.Assert.*;

/**
 *  Para mas ayuda acerca de los metodos junit usados aqui, vease: <br/>
 *  {@link  
 *  	<a href='http://tutorials.jenkov.com/java-unit-testing/asserts.html#assertNull'>
 *  	http://tutorials.jenkov.com/java-unit-testing/asserts.html#assertNull
 *  	</a> 
 *  }
 *   
 * @author gonzasilve
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config/daoContextConfig.xml"})
public class RolesUsuarioServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(RolesUsuarioServiceTest.class);

	@Autowired
	IRolesUsuarioService rolesUsuarioService;
	
	@Autowired
	IUsuarioService usuarioService;
	
	/**
	 * Prueba del metodo findall() de la clase de servicio RolesUsuarioServiceImpl
	 * 
	 * @author gonzasilve
	 */
    //@Test
    @Transactional
    @Ignore
    public void findAllTest() {
        try {
            System.out.println("Inicio del test findAllTest");
            //logger.info("Inicio del test deberiaMostrarRolesUsuario");
            List<RolesUsuario> roles = rolesUsuarioService.findAll();
            System.out.println("Total: "+roles.size());
            int contador = 0;
            for (RolesUsuario rolUsuario : roles) {
            	System.out.println("ID: " + rolUsuario.getIdRol());
            	System.out.println("Descripcion: " + rolUsuario.getDescRolUsuario());
            	contador++;
            }
            // Segun el numero de personas recuperadas, deberia ser el mismo de
            // la tabla
            assertEquals(contador, 2);
            logger.info("Fin del test findAllTest");
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.error("Error service rolesUsuarioService.findAll()", ex);
        }
    }

	/**
	 * Prueba del metodo findByName() de la clase de servicio RolesUsuarioServiceImpl
	 * 
	 * @author gonzasilve
	 */
    //@Test
    @Transactional
    @Ignore
    public void findByNameTest() {
        try {
            logger.info("Inicio del test findByNameTest");
            RolesUsuario rol = rolesUsuarioService.findByName("administrador");
            System.out.println("Id: "+rol.getIdRol());
            System.out.println("Descripcion: "+rol.getDescRolUsuario());
            
            assertNotNull(rol);
            logger.info("Fin del test findByNameTest");
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.error("Error rolesUsuarioService.findByName('string')", ex);
        }
    }

	/**
	 * Prueba del metodo findByIdTest() de la clase de servicio RolesUsuarioServiceImpl
	 * 
	 * @author gonzasilve
	 */
    //@Test
    @Transactional
    @Ignore
    public void findByIdTest() {
        try {
            logger.info("Inicio del test findByIdTestTest");
            RolesUsuario rol = rolesUsuarioService.findById(1);
            System.out.println("Id: "+rol.getIdRol());
            System.out.println("Descripcion: "+rol.getDescRolUsuario());

            
            assertNotNull(rol);
            logger.info("Fin del test findByIdTestTest");
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.error("Error rolesUsuarioService.findById(Integer)", ex);
        }
    }

	/**
	 * Prueba del metodo saveTest() de la clase de servicio RolesUsuarioServiceImpl
	 * 
	 * @author gonzasilve
	 */
    @Test
    @Transactional
    //@Ignore
    public void saveTest() {
        try {
            logger.info("Inicio del test saveTest");
            RolesUsuario rol = rolesUsuarioService.findById(1);
            
            List<Usuario> usrs = new ArrayList<Usuario>();
            Usuario usr1 =new Usuario();
            usr1.setNombre("Wendy");
            usr1.setApellidoPaterno("perez");
            usr1.setApellidoMaterno("salinas");
            usr1.setRolesUsuario(rol);
            Usuario usr2 =new Usuario();
            usr2.setNombre("Marisol");
            usr2.setApellidoPaterno("Salinas");
            usr2.setApellidoMaterno("Apolinar");
            usr2.setRolesUsuario(rol);
            usuarioService.save(usr1);
            usuarioService.save(usr2);
            
            
            //usuarioService.flush();
            usrs.add(usr1);
            usrs.add(usr2);

            
            //RolesUsuario rol = new RolesUsuario();
            //rol.setDescRolUsuario("Prueba");
            //rol.setUsuarios(usrs);

            
            //rolesUsuarioService.save(rol);
            //rolesUsuarioService.flush();
            
            assertNotNull(rol);
            logger.info("Fin del test saveTest");
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.error("Error rolesUsuarioService.save(RolesUsuario)", ex);
        }
    }

}
