package com.notasprogramacion.dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = -565342423787726341L;
	
	private Integer id;
	private String nombre;

	public UsuarioDto() {

	}

	public UsuarioDto(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", nombre=" + nombre + "]";
	}

}
