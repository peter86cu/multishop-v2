package com.ayalait.modelo;

public class ItemsVenta {
	private int idiva;
	private String id;
	private String codigo;
	private int cantidad;
	private double precio;
	private String nombre;
	private String moneda;
	private int id_venta_detalle;

	private int id_cliente;
	public int getIdiva() {
		return idiva;
	}
	public void setIdiva(int idiva) {
		this.idiva = idiva;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public int getId_venta_detalle() {
		return id_venta_detalle;
	}
	public void setId_venta_detalle(int id_venta_detalle) {
		this.id_venta_detalle = id_venta_detalle;
	}


	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
}
