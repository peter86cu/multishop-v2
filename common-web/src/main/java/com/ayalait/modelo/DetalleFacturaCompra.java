package com.ayalait.modelo;



public class DetalleFacturaCompra  {

	private int id_entrada_compra_detalle;
	
	private String id_producto;
	
	private int cantidad;
	
	private int id_entrada_compra;
	
	private double importe;
	
	private int id_moneda;

	

	public int getId_entrada_compra_detalle() {
		return id_entrada_compra_detalle;
	}

	public void setId_entrada_compra_detalle(int id_entrada_compra_detalle) {
		this.id_entrada_compra_detalle = id_entrada_compra_detalle;
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



	public int getId_entrada_compra() {
		return id_entrada_compra;
	}

	public void setId_entrada_compra(int id_entrada_compra) {
		this.id_entrada_compra = id_entrada_compra;
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
