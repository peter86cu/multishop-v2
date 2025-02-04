package com.ayalait.modelo;


import java.io.Serializable;



public class FormasCobro implements Serializable {
	private static final long serialVersionUID = 1L;


	private int idFormaCobro;

	private String descripcion;

	private String simbolo;

	public FormasCobro() {
	}

	public int getIdFormaCobro() {
		return this.idFormaCobro;
	}

	public void setIdFormaCobro(int idFormaCobro) {
		this.idFormaCobro = idFormaCobro;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSimbolo() {
		return this.simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

}