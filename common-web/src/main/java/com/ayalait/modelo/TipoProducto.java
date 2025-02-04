package com.ayalait.modelo;

public class TipoProducto {

	private int id_tipo_producto;

	private String descripcion;

	private int estado;

	public int getId_tipo_producto() {
		return id_tipo_producto;
	}

	public void setId_tipo_producto(int id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
