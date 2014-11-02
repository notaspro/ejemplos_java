
/*
 www.notas-programacion.com
 Descripción:
    Ejemplo con interfaces en java. En java la herencia entre interfaces 
    tambien esta permitida.  Observa como esta interfaz hereda de IDispositivo. 
    Todos los metodos declarados en la clase padre ahora tambien los tiene esta interfaz.
 Archivo: IMicroprocesador.java
 */

package com.notasprogramacion.interfaces.test;

public interface IMicroprocesador extends IDispositivo {
    
    public void procesar();
    
}
