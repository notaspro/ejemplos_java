/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notasprogramacion.interfaces.test;

/**
 *
 * @author gonzasilve
 */
public class Dispositivo implements IDispositivo{

    private int id;
    private String nombre;
    private String modelo;
    private String fabricante;
    
    @Override
    public boolean encender() {
        return false;
    }

    @Override
    public boolean apagar() {
        return false;
    }

    @Override
    public void funcionar() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
}
