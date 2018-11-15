package com.gonzasilve.puntoventas.pvmodel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Descripcion: Clase para mapeo y pesistencia de registros en la tabla
 * <b>tbl_categorias</b><br/>
 * Por medio de esta clase entidad se hace la persistencia de categorias
 * 
 * @author Gonzalo Silverio - silveriosw@gmail.com <br/>
 * 
 *         Fecha: 27-09-2014 <br/>
 */
@Entity
@Table(name = "tbl_categorias")
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCategoria;
	private String nombre;
	private int porcentajeGanancia;
	private String carpetaCategoria;
	private Date fechaRegistro;

	public Categoria() {

	}

	/**
	 * 
	 * @param idCategoria
	 *            Id de la categoria
	 * @param nombre
	 *            Nombre de la categoria
	 * @param porcentajeGanancia
	 *            Porcentaje de ganancia para esta categoria, al establecer un
	 *            porcentaje aqui se calcula para cada producto el precio de
	 *            venta al publico =
	 *            precioCompra+((precioCompra*(porcentajeGanancia/100))
	 * @param carpetaCategoria
	 *            Carpeta donde se guardaran las imagenes de vista previa de los
	 *            productos que esten clasificados en esta categoria *
	 * @param fechaRegistro
	 *            Fecha en que fue registrada esta categoria
	 */
	public Categoria(int idCategoria, String nombre, int porcentajeGanancia,
			String carpetaCategoria, Date fechaRegistro) {
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.porcentajeGanancia = porcentajeGanancia;
		this.carpetaCategoria = carpetaCategoria;
		this.fechaRegistro = fechaRegistro;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Categoria", unique = true, updatable = false, insertable = false)
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name = "tx_Nombre", length = 30, updatable = true, insertable = false, nullable=true)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "porcentajeGanancia", updatable = true, insertable = false, nullable=true)
	public int getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(int porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	@Column(name = "tx_CarpetaCategoria", length = 250, updatable = true, insertable = true, nullable=true)
	public String getCarpetaCategoria() {
		return carpetaCategoria;
	}

	public void setCarpetaCategoria(String carpetaCategoria) {
		this.carpetaCategoria = carpetaCategoria;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_FechaRegistro", nullable = true)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre
				+ ", porcentajeGanancia=" + porcentajeGanancia
				+ ", carpetaCategoria=" + carpetaCategoria + ", fechaRegistro="
				+ fechaRegistro + "]";
	}

}
