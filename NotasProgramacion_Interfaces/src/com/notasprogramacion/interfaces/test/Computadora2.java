/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notasprogramacion.interfaces.test;

import java.util.ArrayList;
import java.util.List;

public class Computadora2 extends Dispositivo implements IComputadora {
    
    private int id;
    
    private List<Dispositivo> lstDispositivos = new ArrayList<>();
    
    @Override
    public boolean encender() {
        System.out.println("\nEncendiendo dispositivos...");
        for(Dispositivo disp : lstDispositivos) {
            disp.encender();
            disp.funcionar();
        }
        System.out.println("Computadora encendida...\n");
        return true;
    }

    @Override
    public boolean apagar() {
        System.out.println("\nApagando dispositivos...");
        for(Dispositivo disp : lstDispositivos) {
            disp.apagar();
        }
        System.out.println("Computadora apagada.\n\n");
        return true; 
    }

    public List<Dispositivo> getLstDispositivos() {
        return lstDispositivos;
    }

    public void setLstDispositivos(List<Dispositivo> lstDispositivos) {
        this.lstDispositivos = lstDispositivos;
    }

    @Override
    public void funcionar() {
       System.out.println("\nComputadora funcionando \n");
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    //@Override
    public String toString() {
        StringBuilder strDispositivos = new StringBuilder();
        strDispositivos.append("");
        for(Dispositivo disp : lstDispositivos ) {
            strDispositivos.append("Computadora{ \n [ "+disp.getNombre()+"{ "
                + "id = " +disp.getId() + ",");
            
                String newStr = "";
                if(disp instanceof DiscoDuro) {
                    DiscoDuro hd = (DiscoDuro)disp;
                    newStr += "capacidad = " +hd.getCapacidad() + " GB,";
                    strDispositivos.append(newStr);
                }
                if(disp instanceof MemoriaRAM) {
                    MemoriaRAM memoria = (MemoriaRAM)disp;
                    newStr += "capacidad = " +memoria.getCapacidad() + " GB,";
                    strDispositivos.append(newStr);
                }
                if(disp instanceof Microprocesador) {
                    Microprocesador procesador = (Microprocesador)disp;
                    newStr += "velocidad = " +procesador.getVelocidad()+ " GHz,";
                    strDispositivos.append(newStr);
                }
                
                strDispositivos.append( " modelo= " +disp.getModelo() + ","
                    + "fabricante= " +disp.getFabricante()
                    + " } ],");
                

        }
        
        return strDispositivos.toString();
    }

    @Override
    public void guardarDocumento() {
        
    }

    @Override
    public void graficar() {
        
    }

    @Override
    public void chatear() {
        
    }

    @Override
    public void navegar() {
        
    }

    @Override
    public void reproducirMusica() {
        
    }

    @Override
    public void reproducirVideo() {
        
    }

    @Override
    public void abrirPrograma() {
        
    }


    
}
