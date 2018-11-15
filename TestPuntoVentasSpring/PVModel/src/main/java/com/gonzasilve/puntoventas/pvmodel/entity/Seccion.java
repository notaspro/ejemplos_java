package com.gonzasilve.puntoventas.pvmodel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Descripcion: Clase entidad para mapeo de la tabla app_secciones
 * 
 * @author gonzasilve Date: 21-08-2014
 * 
 */
@Entity
@Table(name = "app_secciones")
public class Seccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSeccion;
	private String nombreSeccion;
	private String nombreCapa;
	private String urlSeccion;
	private Integer activa;
	private Integer orden;

	public Seccion() {

	}

	public Seccion(Integer idSeccion, String nombreSeccion, String urlSeccion,
			Integer activa, Integer orden) {
		this.idSeccion = idSeccion;
		this.nombreSeccion = nombreSeccion;
		this.urlSeccion = urlSeccion;
		this.activa = activa;
		this.orden = orden;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_seccion", unique = true, nullable = false)
	public Integer getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	@Column(name = "tx_NombreSeccion", length = 100, insertable = true, updatable = true, nullable = true)
	public String getNombreSeccion() {
		return nombreSeccion;
	}

	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	@Column(name = "tx_NombreCapa", length = 20, insertable = true, updatable = true, nullable = true)
	public String getNombreCapa() {
		return nombreCapa;
	}

	public void setNombreCapa(String nombreCapa) {
		this.nombreCapa = nombreCapa;
	}

	@Column(name = "tx_UrlSeccion", length = 500, insertable = true, updatable = true, nullable = true)
	public String getUrlSeccion() {
		return urlSeccion;
	}

	public void setUrlSeccion(String urlSeccion) {
		this.urlSeccion = urlSeccion;
	}

	@Column(name = "i_activa", nullable = false, updatable = true, insertable = true)
	public Integer getActiva() {
		return activa;
	}

	public void setActiva(Integer activa) {
		this.activa = activa;
	}

	@Column(name = "orden", nullable = true, insertable = true, updatable = true)
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "Seccion [idSeccion=" + idSeccion + ", nombreSeccion="
				+ nombreSeccion + ", nombreCapa=" + nombreCapa
				+ ", urlSeccion=" + urlSeccion + ", activa=" + activa
				+ ", orden=" + orden + "]";
	}

}
