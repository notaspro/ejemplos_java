package com.notasprogramacion.di.ejemplo1;

public class RodarVehiculo {

	IVehiculo vehiculo;

	public RodarVehiculo() {
		
	}

	public void setVehiculo(IVehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public void rodar() {
		this.vehiculo.rodar();
	}
}
