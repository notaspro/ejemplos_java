
/*
 www.notas-programacion.com
 Descripción:
    Ejemplo de un POJO
 Archivo: Tarjeta.java
 */

package com.notasprogramacion.pojos;

import java.math.BigInteger;

/**
 * Clase para encapsular los datos de una tarjeta bancaria 
 * @author notaspro - www.notas-programacion.com
 * @version 1.0
 * Última actualización: 02-10-2014 por notaspro 
 */
public class Tarjeta {
    
    //atributos
    private BigInteger numero;
    private String nombre;
    private String tipoTarjeta;
    private String nombreBanco;
    private Short fechaExpiracionAnio;
    private Byte fechaExpiracionMes;
    private Short codigoVerificacion;
    private boolean isDebito;
    private boolean isCredito;

    //getters y setters
    /**
     * Número de tarjeta
     * @return 
     * <ul>
     *  <li><strong>{@link java.math.BigInteger BigInteger}</strong> El cual es el número de la tarjeta</li>
     *  <li><strong>null</strong> Si el número de tarjeta no ha sido asignado</li>
     * </ul>
     */
    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    /**
     * Nombre de la tarjeta, ejemplo: Súper nomina ó Cochinito
     * @return 
     * <ul>
     *  <li><strong>{@link java.lang.String String}</strong> El cual es el nombre de la tarjeta</li>
     *  <li><strong>null</strong> Si el nombre de la tarjeta no ha sido asignado</li>
     * </ul>
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Tipo de tarjeta, ejemplo: VISA ó MASTERCARD
     * @return 
     * <ul>
     *  <li><strong>{@link java.lang.String String}</strong> El cual es el tipo de la tarjeta</li>
     *  <li><strong>null</strong> Si el tipo de la tarjeta no ha sido asignado</li>
     * </ul>
     */
    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    /**
     * Nombre del banco al que pertenece la tarjeta
     * @return 
     * <ul>
     *  <li><strong>{@link java.lang.String String}</strong> El cual es el nombre del banco</li>
     *  <li><strong>null</strong> Si el nombre del banco no ha sido asignado</li>
     * </ul>
     */
    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
    
    
    /**
     * Año de la fecha de expiración. Cuatro dígitos
     * @return 
     * <ul>
     *  <li><strong>{@link java.lang.Short Short}</strong> El cual es el año de la fecha de expiracion</li>
     *  <li><strong>null</strong> Si el año de expiración no ha sido asignado</li>
     * </ul>
     */
    public Short getFechaExpiracionAnio() {
        return fechaExpiracionAnio;
    }

    public void setFechaExpiracionAnio(Short fechaExpiracionAnio) {
        this.fechaExpiracionAnio = fechaExpiracionAnio;
    }

    /**
     * Mes de la fecha de expiración. Dos digitos
     * @return 
     * <ul>
     *  <li><strong>{@link java.lang.Byte Byte}</strong> El cual es el mes de la fecha de expiracion</li>
     *  <li><strong>null</strong> Si el mes de expiración no ha sido asignado</li>
     * </ul>
     */
    public Byte getFechaExpiracionMes() {
        return fechaExpiracionMes;
    }

    public void setFechaExpiracionMes(Byte fechaExpiracionMes) {
        this.fechaExpiracionMes = fechaExpiracionMes;
    }

    /**
     * Código de verificación de la tarjeta, generalmente impreso <br/>
     * en el reverso de la tarjeta en el área de la firma. Tres dígitos
     * @return 
     * <ul>
     *  <li><strong>{@link java.lang.Short Short}</strong> El cual es código de verificación de la tarjeta</li>
     *  <li><strong>null</strong> Si el código de verificación de la tarjeta no ha sido asignado</li>
     * </ul>
     */
    public Short getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(Short codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    /**
     * Valor booleano para saber si la tarjeta es de débito
     * @return 
     * <ul>
     *  <li><strong>true</strong> si la tarjeta SI es de débito</li>
     *  <li><strong>false</strong> si la tarjeta NO es de débito</li>
     * </ul>
     */
    public boolean getIsDebito() {
        return isDebito;
    }

    public void setIsDebito(boolean isDebito) {
        this.isDebito = isDebito;
    }

    /**
     * Valor booleano para saber si la tarjeta es de crédito
     * @return 
     * <ul>
     *  <li><strong>true</strong> si la tarjeta SI es de crédito</li>
     *  <li><strong>false</strong> si la tarjeta NO es de crédito</li>
     * </ul>
     */
    public boolean getIsCredito() {
        return isCredito;
    }

    public void setIsCredito(boolean isCredito) {
        this.isCredito = isCredito;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "numero=" + numero + ", nombre=" + nombre + ", tipoTarjeta=" + tipoTarjeta + ", nombreBanco=" + nombreBanco + ", fechaExpiracionAnio=" + fechaExpiracionAnio + ", fechaExpiracionMes=" + fechaExpiracionMes + ", codigoVerificacion=" + codigoVerificacion + ", isDebito=" + isDebito + ", isCredito=" + isCredito + '}';
    }

}
