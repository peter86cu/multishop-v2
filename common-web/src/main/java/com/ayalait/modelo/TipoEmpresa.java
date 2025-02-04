package com.ayalait.modelo;

import java.io.Serializable;



public class TipoEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String id;
	
	
	private String descripcion;
	
	private String estado;
	
	
	public TipoEmpresa() {
		super();
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}