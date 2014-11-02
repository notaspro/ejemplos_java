
/*
 www.notas-programacion.com
 Descripción:
    Ejemplo con interfaces en java. En java la herencia entre interfaces 
    tambien esta permitida.  Observa como esta interfaz hereda de IDispositivo. 
    Todos los metodos declarados en la clase padre ahora tambien los tiene esta interfaz.
 Archivo: IComputadora.java
 */

package com.notasprogramacion.interfaces.test;

public interface IComputadora extends IDispositivo {

    public abstract void graficar();
    public void guardarDocumento();
    public void chatear();
    public void navegar();
    public void reproducirMusica();
    public void reproducirVideo();
    public abstract void abrirPrograma();
    // ...etc
}
