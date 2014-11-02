
/*
 www.notas-programacion.com
 Descripción:
    Ejemplo con interfaces en java. La palabra implements es la palabra reservada que tiene java 
    para implementar los metodos de una interfaz
 Archivo: Microprocesador.java
 */

package com.notasprogramacion.interfaces.test;

public class Microprocesador extends Dispositivo implements IMicroprocesador {
    
    private int velocidad;

    public Microprocesador() {
        
    }
    
    @Override
    public boolean encender() {
        System.out.println("Microprocesador encendido");
        return true;
    }
    
    @Override
    public boolean apagar() {
        System.out.println("Microprocesador apagado");
        return true;
    }
    
    @Override
    public void funcionar() {
        System.out.println("Microprocesador funcionando");
    }

    @Override
    public void procesar() {
        System.out.println("procesando...");
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

}
