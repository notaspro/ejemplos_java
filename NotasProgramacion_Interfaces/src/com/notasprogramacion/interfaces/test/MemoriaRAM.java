
/*
 www.notas-programacion.com
 Descripción:
    Ejemplo con interfaces en java. La palabra implements es la palabra reservada que tiene java 
    para implementar los metodos de una interfaz
 Archivo: MemoriaRAM.java
 */

package com.notasprogramacion.interfaces.test;

public class MemoriaRAM extends Dispositivo implements IDispositivoAlmacenamiento {
    private int capacidad;

    @Override
    public boolean encender() {
        System.out.println("Memoria RAM encendida");
        return true;
    }

    @Override
    public boolean apagar() {
        System.out.println("Memoria RAM apagada");
        return true; 
    }

    @Override
    public void funcionar() {
       System.out.println("Memoria RAM funcionando");
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public boolean escritura() {
        System.out.println("Escribiendo en Memoria RAM");
        return true;
    }

    @Override
    public boolean lectura() {
        System.out.println("Leyendo Memoria RAM");
        return true;
    }
}
