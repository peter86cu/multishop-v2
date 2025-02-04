package com.ayalait.modelo;




public class Categoria {
	
	private int id_categoria_producto;
	private int id_tipo_producto;
	private String categoria;
	private String descripcion;
	private int estado;

	
	
	public int getId_categoria_producto() {
		return id_categoria_producto;
	}



	public void setId_categoria_producto(int id_categoria_producto) {
		this.id_categoria_producto = id_categoria_producto;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return  categoria;
	}



	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId_tipo_producto() {
		return id_tipo_producto;
	}



	public void setId_tipo_producto(int id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}
	
	
	
	

}
