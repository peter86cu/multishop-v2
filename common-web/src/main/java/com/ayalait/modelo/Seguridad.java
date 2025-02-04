package com.ayalait.modelo;

import java.io.Serializable;




public class Seguridad implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	
	private String idUsuario;
	
	private String fecha_login;
	
	private String fecha_logout;
	
	private String token;
	
	private String accion;
	
	private String metadata;
	
	private String resultado;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFecha_login() {
		return fecha_login;
	}

	public void setFecha_login(String fecha_login) {
		this.fecha_login = fecha_login;
	}

	public String getFecha_logout() {
		return fecha_logout;
	}

	public void setFecha_logout(String fecha_logout) {
		this.fecha_logout = fecha_logout;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Seguridad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	
	
}
