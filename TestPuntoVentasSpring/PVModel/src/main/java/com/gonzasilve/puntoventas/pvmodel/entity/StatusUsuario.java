package com.gonzasilve.puntoventas.pvmodel.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Descripcion: Clase Entidad para la persistencia los Status del usuario <br/>
 * 
 * @author: Gonzalo Silverio - silveriosw@gmail.com <br/>
 * 
 *          Fecha: 11-09-2014 <br/>
 * 
 */

@Entity
@Table(name = "app_statususuario")
public class StatusUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idStatus;

	private String descripcion;

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public StatusUsuario() {

	}

	public StatusUsuario(int idStatus, String descripcion) {
		this.idStatus = idStatus;
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_StatusUsuario", unique = true)
	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	@Column(name = "tx_StatusUsuario", length = 60, insertable = true, updatable = true, nullable = true)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// El lado inverso debe saber cuál es el nombre que lo representa en el lado
	// dueño. Para esto se usa el elemento "mappedBy".
	@OneToMany(mappedBy = "statusUsuario", fetch = FetchType.LAZY)
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
