package com.ayalait.modelo;

import java.io.Serializable;


public class UserAdd implements Serializable {

    private static final long serialVersionUID = 1L;

	private String idusuario;

	private String email;

	private String fechaalta;

	private String fechabaja;

	private String usuario;

	private String password;

	private int idrol;

	private int estado;
	
	private String idempleado;

	public UserAdd() {
		super();
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(String fechaalta) {
		this.fechaalta = fechaalta;
	}

	public String getFechabaja() {
		return fechabaja;
	}

	public void setFechabaja(String fechabaja) {
		this.fechabaja = fechabaja;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(String idempleado) {
		this.idempleado = idempleado;
	}

	public UserAdd(String idusuario, String email, String fechaalta, String fechabaja, String usuario, String password,
			int idrol, int estado, String idempleado) {
		super();
		this.idusuario = idusuario;
		this.email = email;
		this.fechaalta = fechaalta;
		this.fechabaja = fechabaja;
		this.usuario = usuario;
		this.password = password;
		this.idrol = idrol;
		this.estado = estado;
		this.idempleado = idempleado;
	}

	

	

}
