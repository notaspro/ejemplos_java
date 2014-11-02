
/*
 www.notas-programacion.com
 Descripción:
    Ejemplo de un POJO
 Archivo: Producto.java
 */

package com.notasprogramacion.pojos;

import java.math.BigDecimal;
import java.util.Date;


public class Producto {
    
    //atributos
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precioProveedor;
    private BigDecimal precioPublico;
    private Date fechaCaducidad;
    
    //getters y setters
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(BigDecimal precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public BigDecimal getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(BigDecimal precioPublico) {
        this.precioPublico = precioPublico;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioProveedor=" + precioProveedor + ", precioPublico=" + precioPublico + ", fechaCaducidad=" + fechaCaducidad + '}';
    }
    
}
