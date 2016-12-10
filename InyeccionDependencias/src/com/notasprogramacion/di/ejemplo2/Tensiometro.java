package com.notasprogramacion.di.ejemplo2;

public class Tensiometro implements IHerramientaTrabajo {

	private String nombre = "Tensiometro";
	
	public Tensiometro() {
		
	}

	@Override
	public void funcionar() {
		System.out.println("Soy un " + this.nombre + ", estoy midiendo tu presión arterial...");
	}
}
