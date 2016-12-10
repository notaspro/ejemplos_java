package com.notasprogramacion.di.ejemplo2;

import java.util.List;

public class Trabajador {

	private List<IHerramientaTrabajo> herramientas;
	private String nombreProfesion;
	
	public Trabajador(String nombreProfesion) {
		this.nombreProfesion = nombreProfesion;
	}

	public void setHerramientas(List<IHerramientaTrabajo> herramientas) {
		this.herramientas = herramientas;
	}
	
	public void trabajar() {
		System.out.println("Soy un "+this.nombreProfesion+", empezare a trabajar...");
		for(IHerramientaTrabajo herramientaTrabajo : herramientas) {
			herramientaTrabajo.funcionar();
		}
	}
}
