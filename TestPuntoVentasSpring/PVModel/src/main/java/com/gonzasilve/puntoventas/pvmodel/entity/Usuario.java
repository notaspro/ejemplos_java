package com.gonzasilve.puntoventas.pvmodel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Description: Clase Entidad para la persistencia de Usuarios <br/>
 * 
 * @author: Gonzalo Silverio - silveriosw@gmail.com<br/>
 * 
 * Fecha: 07-09-2014 <br/>
 * 
 * Agregar Llave foranea a tabla existente: 
 * http://www.w3schools.com/sql/sql_foreignkey.asp
 * 
 * Ejemplo: 
 * ALTER TABLE app_usuarios
 * ADD FOREIGN KEY (id_RolUsuario)
 * REFERENCES app_rolesusuario(id_RolUsuario)
 * 
 */
@Entity
@Table(name = "app_usuarios")
public class Usuario implements Serializable {

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

	private RolesUsuario rolesUsuario;

	private StatusUsuario statusUsuario;
	
    private Usuario usuarioAlta;
    
	// private int id_usuarioAlta;


	private Date fechaRegistro;

	private Date ultimaModificacionUsuario;

	private Date ultimaModificacionPw;

	public Usuario() {

	}

	public Usuario( String username, String password,
			String nombre, String apellidoPaterno, String apellidoMaterno,
			String email, RolesUsuario rolesUsuario, Date fechaRegistro,
			Date ultimaModificacionUsuario, Date ultimaModificacionPw) {
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.email = email;
		this.rolesUsuario = rolesUsuario;
		this.fechaRegistro = fechaRegistro;
		this.ultimaModificacionUsuario = ultimaModificacionUsuario;
		this.ultimaModificacionPw = ultimaModificacionPw;
	}

	public Usuario(int id_usuario, String username, String password,
			String nombre, String apellidoPaterno, String apellidoMaterno,
			String email, Date fechaRegistro, Date ultimaModificacionUsuario,
			Date ultimaModificacionPw) {
		this.id_usuario = id_usuario;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.email = email;
		this.fechaRegistro = fechaRegistro;
		this.ultimaModificacionUsuario = ultimaModificacionUsuario;
		this.ultimaModificacionPw = ultimaModificacionPw;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Usuario", unique = true)
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Column(updatable = true, name = "tx_username", nullable = true, length = 30)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(updatable = true, name = "tx_password", nullable = true, length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(updatable = true, name = "tx_Nombre", nullable = true, length = 50)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(updatable = true, name = "tx_ApellidoPaterno", nullable = true, length = 50)
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	@Column(updatable = true, name = "tx_ApellidoMaterno", nullable = true, length = 50)
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	@Column(updatable = true, name = "tx_Email", nullable = true, length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//En el caso de las relaciones bidireccionales, usando anotaciones, el 
	//dueño SIEMPRE es el lado muchos (esta es una regla).
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_RolUsuario")
	public RolesUsuario getRolesUsuario() {
		return rolesUsuario;
	}

	public void setRolesUsuario(RolesUsuario rolesUsuario) {
		this.rolesUsuario = rolesUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_StatusUsuario")
	public StatusUsuario getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(StatusUsuario statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="id_UsuarioAlta")
	public Usuario getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(Usuario usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_FechaRegistro", nullable = true)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_UltimaModificacionUsuario", nullable = true)
	public Date getUltimaModificacionUsuario() {
		return ultimaModificacionUsuario;
	}

	public void setUltimaModificacionUsuario(Date ultimaModificacionUsuario) {
		this.ultimaModificacionUsuario = ultimaModificacionUsuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_UltimaModificacionPw", nullable = true)
	public Date getUltimaModificacionPw() {
		return ultimaModificacionPw;
	}

	public void setUltimaModificacionPw(Date ultimaModificacionPw) {
		this.ultimaModificacionPw = ultimaModificacionPw;
	}

}
