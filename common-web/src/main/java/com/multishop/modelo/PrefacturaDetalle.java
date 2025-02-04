package com.multishop.modelo;

import javax.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "prefactura_detalle")
public class PrefacturaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_prefactura_detalle;
	private String id_producto;
	private int cantidad;
	private String id_prefactura;
	private double importe;
	private int id_moneda;

	public String getId_producto() {
		return this.id_producto;
	}

	public void setId_producto(final String id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(final int cantidad) {
		this.cantidad = cantidad;
	}	

	public int getId_prefactura_detalle() {
		return id_prefactura_detalle;
	}

	public void setId_prefactura_detalle(int id_prefactura_detalle) {
		this.id_prefactura_detalle = id_prefactura_detalle;
	}

	public String getId_prefactura() {
		return id_prefactura;
	}

	public void setId_prefactura(String id_prefactura) {
		this.id_prefactura = id_prefactura;
	}

	public double getImporte() {
		return this.importe;
	}

	public void setImporte(final double importe) {
		this.importe = importe;
	}

	public int getId_moneda() {
		return this.id_moneda;
	}

	public void setId_moneda(final int id_moneda) {
		this.id_moneda = id_moneda;
	}

}
