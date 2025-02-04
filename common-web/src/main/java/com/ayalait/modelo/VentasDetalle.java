package com.ayalait.modelo;

import java.math.BigDecimal;

public class VentasDetalle  {


	private int idVentaDetalle;

	private BigDecimal cantidad;

	private int idMonedaCompra;

	private int idMonedaVenta;

	private String idProducto;

	private int idVenta;

	private BigDecimal precioCompra;

	private BigDecimal precioVenta;

	public VentasDetalle() {
	}

	public int getIdVentaDetalle() {
		return this.idVentaDetalle;
	}

	public void setIdVentaDetalle(int idVentaDetalle) {
		this.idVentaDetalle = idVentaDetalle;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdMonedaCompra() {
		return this.idMonedaCompra;
	}

	public void setIdMonedaCompra(int idMonedaCompra) {
		this.idMonedaCompra = idMonedaCompra;
	}

	public int getIdMonedaVenta() {
		return this.idMonedaVenta;
	}

	public void setIdMonedaVenta(int idMonedaVenta) {
		this.idMonedaVenta = idMonedaVenta;
	}

	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public BigDecimal getPrecioCompra() {
		return this.precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public BigDecimal getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

}