package com.gonzasilve.puntoventas.pvcore.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gonzasilve.puntoventas.pvmodel.entity.Seccion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config/daoContextConfig.xml"})
public class SeccionServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(SeccionServiceTest.class);

	@Autowired
	ISeccionService seccionService;
	

    //@Test
    @Transactional
    @Ignore
    public void findAllSeccionesTest() {
        try {
            logger.info("Inicio del test findAllSeccionesTest");
            //logger.info("Inicio del test deberiaMostrarRolesUsuario");
            List<Seccion> secciones = seccionService.findAll();
            
            int contador = 0;
            for (Seccion seccion : secciones) {
            	System.out.println("ID: " + seccion.getIdSeccion() );
            	System.out.println("Nombre: " + seccion.getNombreSeccion() );
            	System.out.println("URL: " + seccion.getUrlSeccion() );
            	System.out.println("Activa: " + seccion.getActiva() );
            	contador++;
            }
            // Segun el numero de personas recuperadas, deberia ser el mismo de
            // la tabla
            assertNotNull(secciones);
            logger.info("Fin del test findAllSeccionesTest");
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.error("Error Dao", ex);
        }
    }

    

    @Test
    @Transactional
    //@Ignore
    public void searchAndOrder() {
        try {
            logger.info("Inicio del test searchAndOrder");
            //logger.info("Inicio del test deberiaMostrarRolesUsuario");
            List<Seccion> secciones = seccionService.searchAllAndOrderByColumn("orden");
            
            int contador = 0;
            for (Seccion seccion : secciones) {
            	System.out.println(seccion.toString() );
            	contador++;
            }
            // Segun el numero de personas recuperadas, deberia ser el mismo de
            // la tabla
            assertNotNull(secciones);
            logger.info("Fin del test searchAndOrder");
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.error("Error Dao", ex);
        }
    }

}