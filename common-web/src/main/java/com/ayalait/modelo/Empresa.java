package com.ayalait.modelo;

import java.io.Serializable;

public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String id_empresa;
	
	
	private String nombre;

	private String rut;

	private String direccion;

	private String telefono;

	private String email;
	
	private String fechaInicio;
	
	private String fechaFin;
	
	private String idEstado;
	
	private String idTipoEmpresa;
	
	private boolean sucursales;
	
	public Empresa() {
		super();
	}

	public String getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(String id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public String getIdTipoEmpresa() {
		return idTipoEmpresa;
	}

	public void setIdTipoEmpresa(String idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}

	public boolean isSucursales() {
		return sucursales;
	}

	public void setSucursales(boolean sucursales) {
		this.sucursales = sucursales;
	}

	

}