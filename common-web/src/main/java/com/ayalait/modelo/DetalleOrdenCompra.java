package com.ayalait.modelo;



public class DetalleOrdenCompra  {
	
	private int id_orden_de_compra_detalle;
	
	private String id_producto;
	
	private int cantidad;
	
	private int id_orden_compra;
	
	private double importe;
	
	private int id_moneda;

	public int getId_orden_de_compra_detalle() {
		return id_orden_de_compra_detalle;
	}

	public void setId_orden_de_compra_detalle(int id_orden_de_compra_detalle) {
		this.id_orden_de_compra_detalle = id_orden_de_compra_detalle;
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_orden_compra() {
		return id_orden_compra;
	}

	public void setId_orden_compra(int id_orden_compra) {
		this.id_orden_compra = id_orden_compra;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public int getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(int id_moneda) {
		this.id_moneda = id_moneda;
	}
	
	
}
