
/*
 www.notas-programacion.com
 Descripción:
    Ejemplo con interfaces en java.
 Archivo: TestInterfaces.java
 */

package com.notasprogramacion.interfaces.test;

public class TestInterfaces {
    
    public static void main(String []args) {
        
        DiscoDuro hd = new DiscoDuro();
        hd.setId(1);
        hd.setNombre("HD Maxtor");
        hd.setModelo("PROMAX");
        hd.setFabricante("Maxtor");
        hd.setCapacidad(512);
        
        MemoriaRAM ram = new MemoriaRAM();
        ram.setId(1);
        ram.setNombre("RAM Kingston");
        ram.setModelo("NANDVER");
        ram.setFabricante("Kingston");
        ram.setCapacidad(16);
                
        Microprocesador procesador = new Microprocesador();
        procesador.setId(1);
        procesador.setNombre("AMD Athlon");
        procesador.setModelo("Athlon");
        procesador.setFabricante("AMD");
        procesador.setVelocidad(3);
                
        Computadora pc = new Computadora();
        pc.setDiscoDuro(hd);
        pc.setMemoriaRam(ram);
        pc.setMicropocesador(procesador);
        
        pc.encender();
        pc.funcionar();
        System.out.println(pc.toString());
        pc.apagar();
        
        
        System.out.println("############ USANDO REFERENCIAS A INTERFACES ############");        
        //Tambien se permite crear referencias a interfaces. Para crear una referencia a una interface se utiliza la siguiente sintaxis:
        //NombreInterfaz miRefencia = new ClaseImplementaANombreInterfaz;
        //Ejemplos:

        IMicroprocesador miProc = new Microprocesador();
        miProc.encender();
        miProc.funcionar();
        miProc.procesar();
        miProc.apagar();
        System.out.println();
                
        IDispositivoAlmacenamiento miMemoria = new MemoriaRAM();
        miMemoria.encender();
        miMemoria.funcionar();
        miMemoria.escritura();
        miMemoria.apagar();
        System.out.println();
        
        IDispositivoAlmacenamiento miHD = new DiscoDuro();
        miHD.encender();
        miHD.funcionar();
        miHD.escritura();
        miHD.apagar();
        System.out.println();
    }
}
