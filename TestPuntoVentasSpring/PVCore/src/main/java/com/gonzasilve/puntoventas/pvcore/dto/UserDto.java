package com.gonzasilve.puntoventas.pvcore.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Dto para encapsular datos de un {@link com.gonzasilve.puntoventas.pvmodel.entity.Usuario Usuario}
 * @author gonzasilve
 *
 */
public class UserDto implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id_usuario;

	private String username;

	private String password;

	private String nombre;

	private String apellidoPaterno;

	private String apellidoMaterno;

	private String email;

	private int idRol;

	private int idStatus;
	
    private int idUusuarioAlta;
    
	// private int id_usuarioAlta;


	private Date fechaRegistro;

	private Date ultimaModificacionUsuario;

	private Date ultimaModificacionPw;

	
	public UserDto() {

	}

	
	public UserDto(int id_usuario, String username, String password,
			String nombre, String apellidoPaterno, String apellidoMaterno,
			String email, int idRol, int idStatus, int idUusuarioAlta,
			Date fechaRegistro, Date ultimaModificacionUsuario,
			Date ultimaModificacionPw) {

		this.id_usuario = id_usuario;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.email = email;
		this.idRol = idRol;
		this.idStatus = idStatus;
		this.idUusuarioAlta = idUusuarioAlta;
		this.fechaRegistro = fechaRegistro;
		this.ultimaModificacionUsuario = ultimaModificacionUsuario;
		this.ultimaModificacionPw = ultimaModificacionPw;
	}


	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public int getIdUusuarioAlta() {
		return idUusuarioAlta;
	}

	public void setIdUusuarioAlta(int idUusuarioAlta) {
		this.idUusuarioAlta = idUusuarioAlta;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getUltimaModificacionUsuario() {
		return ultimaModificacionUsuario;
	}

	public void setUltimaModificacionUsuario(Date ultimaModificacionUsuario) {
		this.ultimaModificacionUsuario = ultimaModificacionUsuario;
	}

	public Date getUltimaModificacionPw() {
		return ultimaModificacionPw;
	}

	public void setUltimaModificacionPw(Date ultimaModificacionPw) {
		this.ultimaModificacionPw = ultimaModificacionPw;
	}
	
	/* Util methods */
	public String getPartialName() {
		return this.getNombre()+" "+this.getApellidoPaterno();
	}
	
	public boolean isAdmin() {
		return this.idRol==1;
	}
	
	
	
	
}
