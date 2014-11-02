
/*
 www.notas-programacion.com
 Descripción:
    Ejemplo con interfaces en java. La palabra implements es la palabra reservada que tiene java 
    para implementar los metodos de una interfaz
 Archivo: DiscoDuro.java
 */

package com.notasprogramacion.interfaces.test;

public class DiscoDuro extends Dispositivo implements IDispositivoAlmacenamiento  {
    private int capacidad;

    @Override
    public boolean encender() {
        System.out.println("Disco duro encendido");
        return true;
    }

    @Override
    public boolean apagar() {
        System.out.println("Disco duro apagado");
        return true; 
    }

    @Override
    public void funcionar() {
       System.out.println("Disco duro funcionando");
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public boolean escritura() {
        System.out.print("Escribiendo en Disco duro");
        return true;
    }

    @Override
    public boolean lectura() {
        System.out.print("Leyendo Disco duro");
        return true;
    }
    
}
