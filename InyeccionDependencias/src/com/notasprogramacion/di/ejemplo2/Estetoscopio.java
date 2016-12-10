package com.notasprogramacion.di.ejemplo2;

public class Estetoscopio implements IHerramientaTrabajo {
	
	private String nombre = "Estetoscopio";

	public Estetoscopio() {
		
	}

	@Override
	public void funcionar() {
		System.out.println("Soy un "+this.nombre+", estoy escuchando tu corazón, pulmones y abdomen...");
	}
		
}
