package com.notasprogramacion.di.ejemplo1;

public class EjemploDI {

	public static void main(String[] args) {
		RodarVehiculo rodarVehiculo = new RodarVehiculo();
		
		IVehiculo bicicleta = new Bicicleta();		
		rodarVehiculo.setVehiculo(bicicleta);
		rodarVehiculo.rodar();
		
		IVehiculo motocicleta = new Motocicleta();		
		rodarVehiculo.setVehiculo(motocicleta);
		rodarVehiculo.rodar();
		
		IVehiculo auto = new Auto();		
		rodarVehiculo.setVehiculo(auto);
		rodarVehiculo.rodar();
		
	}

}
