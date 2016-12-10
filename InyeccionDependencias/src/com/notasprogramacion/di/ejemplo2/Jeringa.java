package com.notasprogramacion.di.ejemplo2;

public class Jeringa implements IHerramientaTrabajo {

	private String nombre = "Jeringa";

	public Jeringa() {
		
	}

	@Override
	public void funcionar() {
		System.out.println("Soy una " + this.nombre + ", estoy pinchando...");
	}

}
