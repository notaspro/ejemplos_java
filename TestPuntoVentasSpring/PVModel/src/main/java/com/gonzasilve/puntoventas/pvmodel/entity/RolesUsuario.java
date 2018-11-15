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
 * Descripcion: Clase Entidad para la persistencia de Roles de usuario <br/>
 * 
 * @author: Gonzalo Silverio - silveriosw@gmail.com <br/>
 * 
 * Fecha: 07-09-2014 <br/>
 * 
 */

@Entity
@Table(name = "app_rolesusuario")
public class RolesUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idRol;

	private String descRolUsuario;

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public RolesUsuario() {

	}
	
	public RolesUsuario(int idRol, String descRolUsuario) {
		this.idRol = idRol;
		this.descRolUsuario = descRolUsuario;
	}


	public RolesUsuario(int idRol, String descRolUsuario, List<Usuario> usuarios) {
		super();
		this.idRol = idRol;
		this.descRolUsuario = descRolUsuario;
		this.usuarios = usuarios;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_RolUsuario", unique = true)
	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	@Column(updatable = true, name = "tx_RolUsuario", nullable = true, length = 60)
	public String getDescRolUsuario() {
		return descRolUsuario;
	}

	public void setDescRolUsuario(String descRolUsuario) {
		this.descRolUsuario = descRolUsuario;
	}
	
	//El lado inverso debe saber cuál es el nombre que lo representa en el lado 
	//dueño. Para esto se usa el elemento "mappedBy".
	@OneToMany(mappedBy = "rolesUsuario", fetch = FetchType.LAZY)
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


}
