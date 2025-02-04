package com.ayalait.modelo;

import java.io.Serializable;


public class User implements Serializable {

    private static final long serialVersionUID = 1L;

	private String idusuario;

	private String email;

	private String fechaalta;

	private String fechabaja;

	private String usuario;

	private String password;

	private Roles idrol;

	private int estado;
	
	private Empleado empleado;

	public User() {
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



	public Roles getIdrol() {
		return idrol;
	}

	public void setIdrol(Roles idrol) {
		this.idrol = idrol;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
  

}
