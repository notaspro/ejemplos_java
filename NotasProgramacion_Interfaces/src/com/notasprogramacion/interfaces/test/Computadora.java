/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notasprogramacion.interfaces.test;

/**
 *
 * @author gonzasilve
 */
public class Computadora extends Dispositivo implements IComputadora {
    
    private int id;
    private MemoriaRAM memoriaRam;
    private DiscoDuro discoDuro;
    private Microprocesador micropocesador;
    
    @Override
    public boolean encender() {
        System.out.println("\nEncendiendo dispositivos...");
        this.getDiscoDuro().encender();
        this.getMemoriaRam().encender();
        this.getMicropocesador().encender();
        this.getDiscoDuro().funcionar();
        this.getMemoriaRam().funcionar();
        this.getMicropocesador().funcionar();
        System.out.println("Computadora encendida...\n");
        return true;
    }

    @Override
    public boolean apagar() {
        System.out.println("\nApagando dispositivos...");
        this.getDiscoDuro().apagar();
        this.getMemoriaRam().apagar();
        this.getMicropocesador().apagar();
        System.out.println("Computadora apagada.\n\n");
        return true; 
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
    public MemoriaRAM getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(MemoriaRAM memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public DiscoDuro getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(DiscoDuro discoDuro) {
        this.discoDuro = discoDuro;
    }

    public Microprocesador getMicropocesador() {
        return micropocesador;
    }

    public void setMicropocesador(Microprocesador micropocesador) {
        this.micropocesador = micropocesador;
    }

    //@Override
    public String toString() {
        return "Computadora{ \n[ DiscoDuro{ "
                + "id = " +this.getDiscoDuro().getId() + ","
                + "nombre = " +this.getDiscoDuro().getNombre() + ","
                + "capacidad = " +this.getDiscoDuro().getCapacidad() + " GB,"                
                + "modelo= " +this.getDiscoDuro().getModelo() + ","
                + "fabricante= " +this.getDiscoDuro().getFabricante()
                + " } ], \n[ MemoriaRAM{ "
                + "id = " +this.getMemoriaRam().getId() + ","
                + "nombre = " +this.getMemoriaRam().getNombre() + ","
                + "capacidad = " +this.getMemoriaRam().getCapacidad() + " GB,"                
                + "modelo= " +this.getMemoriaRam().getModelo() + ","
                + "fabricante= " +this.getMemoriaRam().getFabricante()
                + " } ], \n[ Microprocesador{ "
                + "id = " +this.getMicropocesador().getId() + ","
                + "nombre = " +this.getMicropocesador().getNombre() + ","
                + "velocidad = " +this.getMicropocesador().getVelocidad() + " Ghz,"                
                + "modelo= " +this.getMicropocesador().getModelo() + ","
                + "fabricante= " +this.getMicropocesador().getFabricante()
                + " } ] \n}";
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
