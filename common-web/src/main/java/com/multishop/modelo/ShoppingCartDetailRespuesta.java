package com.multishop.modelo;



public class ShoppingCartDetailRespuesta  {

	private String id;
	private String idcart;
	private String idproducto;
	private double precio;
	private int cantidad;
	private String nombre;
	
	
	

	public String getIdcart() {
		return idcart;
	}


	public void setIdcart(String idcart) {
		this.idcart = idcart;
	}


	public String getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public ShoppingCartDetailRespuesta() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	

}
