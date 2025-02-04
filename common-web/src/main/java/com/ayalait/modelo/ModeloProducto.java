package com.ayalait.modelo;



public class ModeloProducto {
	
	
	private int id_modelo;
	private int id_marca;	
	private String modelo;
	private int estado;
	public int getId_marca() {
		return id_marca;
	}
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}
	
	public int getId_modelo() {
		return id_modelo;
	}
	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public ModeloProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
