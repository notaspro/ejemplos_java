
/*
 www.notas-programacion.com
 Descripción:
    Ejemplo con interfaces en java. En java la herencia entre interfaces 
    tambien esta permitida.  Observa como esta interfaz hereda de IDispositivo. 
    Todos los metodos declarados en la clase padre ahora tambien los tiene esta interfaz.
    Observa como esta interfaz hereda de IDispositivo
 Archivo: IDispositivoAlmacenamiento.java
 */

package com.notasprogramacion.interfaces.test;

public interface IDispositivoAlmacenamiento extends IDispositivo {
    
    public boolean escritura();
    public boolean lectura();
    
}
