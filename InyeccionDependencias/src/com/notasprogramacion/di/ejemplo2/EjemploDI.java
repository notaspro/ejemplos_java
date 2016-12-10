package com.notasprogramacion.di.ejemplo2;

import java.util.ArrayList;
import java.util.List;

public class EjemploDI {

	public static void main(String[] args) {
		IHerramientaTrabajo jeringa = new Jeringa();
		IHerramientaTrabajo estetoscopio = new Estetoscopio();
		IHerramientaTrabajo tensiometro = new Tensiometro();
		
		List<IHerramientaTrabajo> herramientas = new ArrayList<>();
		herramientas.add(jeringa);
		herramientas.add(estetoscopio);
		herramientas.add(tensiometro);
		
		Trabajador trabajador = new Trabajador("Medico");
		trabajador.setHerramientas(herramientas);	//DI
		trabajador.trabajar();
		
		//Trabajador Desarrollador = new Trabajador("Desarrollador");
	}
}
