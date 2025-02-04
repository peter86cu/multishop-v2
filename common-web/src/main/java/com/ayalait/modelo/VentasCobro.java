package com.ayalait.modelo;

import java.math.BigDecimal;

public class VentasCobro  {
	

	private int idVentaCobro;

	private BigDecimal cobro;

	private int condicion;

	private BigDecimal cotizacion;


	private int idFormaCobro;

	private int idVenta;

	private int meses;

	private BigDecimal tasaInteres;

	private BigDecimal valor;
	

	public VentasCobro() {
	}

	public int getIdVentaCobro() {
		return this.idVentaCobro;
	}

	public void setIdVentaCobro(int idVentaCobro) {
		this.idVentaCobro = idVentaCobro;
	}

	public BigDecimal getCobro() {
		return this.cobro;
	}

	public void setCobro(BigDecimal cobro) {
		this.cobro = cobro;
	}

	public int getCondicion() {
		return this.condicion;
	}

	public void setCondicion(int condicion) {
		this.condicion = condicion;
	}

	public BigDecimal getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(BigDecimal cotizacion) {
		this.cotizacion = cotizacion;
	}

	public int getIdFormaCobro() {
		return this.idFormaCobro;
	}

	public void setIdFormaCobro(int idFormaCobro) {
		this.idFormaCobro = idFormaCobro;
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getMeses() {
		return this.meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public BigDecimal getTasaInteres() {
		return this.tasaInteres;
	}

	public void setTasaInteres(BigDecimal tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	

}