
/*
 www.notas-programacion.com
 Descripción:
    Ejemplo de un POJO
 Archivo: Usuario.java
 */

package com.notasprogramacion.pojos;

public class Usuario {

    //atributos
    private Integer idUsuario;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private int edad;

    //getters y setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getNombreCompleto() {
        return nombre + " " + apPaterno + " " + apMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
