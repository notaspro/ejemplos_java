/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notasprogramacion.interfaces.test;

import java.util.ArrayList;
import java.util.List;

public class Test2Interfaces {
    
    public static void main(String []args) {
        
        DiscoDuro hd = new DiscoDuro();
        hd.setId(1);
        hd.setNombre("Disco Duro");
        hd.setModelo("PROMAX");
        hd.setFabricante("Maxtor");
        hd.setCapacidad(512);
        
        MemoriaRAM ram = new MemoriaRAM();
        ram.setId(1);
        ram.setNombre("Memoria RAM");
        ram.setModelo("NANDVER");
        ram.setFabricante("Kingston");
        ram.setCapacidad(16);
                
        Microprocesador procesador = new Microprocesador();
        procesador.setId(1);
        procesador.setNombre("Microprocesador");
        procesador.setModelo("Athlon");
        procesador.setFabricante("AMD");
        procesador.setVelocidad(3);
                
        List<Dispositivo> lstDispositivos = new ArrayList<>();
        lstDispositivos.add(hd);
        lstDispositivos.add(ram);
        lstDispositivos.add(procesador);
        
        Computadora2 pc = new Computadora2();
        pc.setLstDispositivos(lstDispositivos);
                
        pc.encender();
        pc.funcionar();
        System.out.println(pc.toString());
        pc.apagar();
    }
}
