package com.multishop.modelo;



public class ShoppingHistoryEstado  {

	private int id;
	private String idcart;
	private int idestado;
	private String fecha;
	private String descripcion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdestado() {
		return idestado;
	}
	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ShoppingHistoryEstado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdcart() {
		return idcart;
	}
	public void setIdcart(String idcart) {
		this.idcart = idcart;
	}

	
	
	

}
