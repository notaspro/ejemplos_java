package com.gonzasilve.puntoventas.pvcore.utils;

import java.util.HashMap;
import java.util.Map;


public class PvCoreConstants {


	public static enum Level {
	    HIGH  (3),  //calls constructor with value 3
	    MEDIUM(2),  //calls constructor with value 2
	    LOW   (1)   //calls constructor with value 1
	    ; // semicolon needed when fields / methods follow


	    private final int levelCode;

	    Level(int levelCode) {
	        this.levelCode = levelCode;
	    }
	    
	        public int getLevelCode() {
	        return this.levelCode;
	        }
	    
	}
	
	public static enum SeccionesApp {
		INVENTARIO(10,"inventario"),
		EMPLEADOS(15,"empleados"),
		PROVEEDORES(20,"proveedores"),
		REPORTES(21,"reportes"),
		PUNTO_VENTAS(30,"puntoventas"),
		CATEGORIAS(41,"categorias"),
		CONFIGURACION(77,"config"),
		ALL_SECTIONS(1000),
		HOME(1001,"home");
		
		// Reverse-lookup map for getting a day from an abbreviation
        private static final Map<Integer, SeccionesApp> lookup = new HashMap<Integer, SeccionesApp>();
        static {
            for (SeccionesApp sec : SeccionesApp.values())
                lookup.put(sec.getIdSeccion(), sec);
        }
        
		private int id;
		private String nombreCapa;
				
		SeccionesApp(int idSeccion) {
			this.id = idSeccion;
		}
		
		SeccionesApp(int idSeccion, String nombreCapa) {
			this.id = idSeccion;
			this.nombreCapa = nombreCapa;
		}
		
        public int getIdSeccion() {
        	return this.id;
        }
        
        public String getNombreCapaSeccion() {
        	return this.nombreCapa;
        }
		
        public static SeccionesApp getSeccionById(Integer idSec) {
        	return lookup.get(idSec);
        }
		
        
	}
	
	
}
