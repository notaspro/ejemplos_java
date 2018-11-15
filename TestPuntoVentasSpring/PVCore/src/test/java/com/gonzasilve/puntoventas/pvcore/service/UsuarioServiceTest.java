package com.gonzasilve.puntoventas.pvcore.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gonzasilve.puntoventas.pvcore.service.IUsuarioService;
import com.gonzasilve.puntoventas.pvmodel.entity.Usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config/daoContextConfig.xml"})
public class UsuarioServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceTest.class);

	@Autowired
	IUsuarioService usuarioService;
	

    @Test
    @Transactional
    //@Ignore
    public void deberiaMostrarUsuarios() {
        try {
            logger.info("Inicio del test deberiaMostrarUsuarios");
            //logger.info("Inicio del test deberiaMostrarRolesUsuario");
            List<Usuario> usuarios = usuarioService.findAll();
            
            int contador = 0;
            for (Usuario usuario : usuarios) {
            	System.out.println("ID: " + usuario.getId_usuario() );
            	System.out.println("Apellido paterno: " + usuario.getApellidoPaterno() );
            	System.out.println("Apellido materno: " + usuario.getApellidoMaterno() );
            	contador++;
            }
            // Segun el numero de personas recuperadas, deberia ser el mismo de
            // la tabla
            assertEquals(contador, 11);
            logger.info("Fin del test deberiaMostrarUsuarios");
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.error("Error Dao", ex);
        }
    }

    

}

