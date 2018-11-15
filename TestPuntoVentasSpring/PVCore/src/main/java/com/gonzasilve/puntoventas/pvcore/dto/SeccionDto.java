package com.gonzasilve.puntoventas.pvcore.dto;

import java.io.Serializable;

/**
 * Dto para encapsular datos de una {@link com.gonzasilve.puntoventas.pvmodel.entity.Seccion Seccion}
 * 
 * @author gonzasilve
 * Date: 21-09-2014
 * 
 */
public class SeccionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idSeccion;
	private String nombreSeccion;
	private String nombreCapa;
	private String urlSeccion;
	private Integer activa;
	private Integer orden;
	
	public SeccionDto() {

	}

	public SeccionDto(Integer idSeccion, String nombreSeccion,
			String urlSeccion, Integer activa,Integer orden) {

		this.idSeccion = idSeccion;
		this.nombreSeccion = nombreSeccion;
		this.urlSeccion = urlSeccion;
		this.activa = activa;
		this.orden = orden;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	public String getNombreSeccion() {
		return nombreSeccion;
	}

	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	public String getNombreCapa() {
		return nombreCapa;
	}

	public void setNombreCapa(String nombreCapa) {
		this.nombreCapa = nombreCapa;
	}

	public String getUrlSeccion() {
		return urlSeccion;
	}

	public void setUrlSeccion(String urlSeccion) {
		this.urlSeccion = urlSeccion;
	}

	public Integer getActiva() {
		return activa;
	}

	public void setActiva(Integer activa) {
		this.activa = activa;
	}

	
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	// Util method
	public boolean isActive() {
		return this.getActiva() == 1;
	}

	@Override
	public String toString() {
		return "SeccionDto [idSeccion=" + idSeccion + ", nombreSeccion="
				+ nombreSeccion + ", nombreCapa=" + nombreCapa
				+ ", urlSeccion=" + urlSeccion + ", activa=" + activa
				+ ", orden=" + orden + "]";
	}



}
