package com.ayalait.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="contable_centros_costo")
public class CentroCosto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String codigo;
	private String descripcion;
	private String estado;

	public CentroCosto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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