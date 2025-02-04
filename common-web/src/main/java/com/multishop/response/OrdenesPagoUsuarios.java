package com.multishop.response;

public class OrdenesPagoUsuarios {
	
	private String idorden;
	private String idpago;
	private String idusuario;
	private int iva;
	private int montopagado;
	private String fecha_pago;

	private String fecha_creado;
	private String state;

	private String monedapago;

	private int cantidad;
	private String urlpago;
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public int getMontopagado() {
		return montopagado;
	}
	public void setMontopagado(int montopagado) {
		this.montopagado = montopagado;
	}
	public String getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(String fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getUrlpago() {
		return urlpago;
	}
	public void setUrlpago(String urlpago) {
		this.urlpago = urlpago;
	}
	public String getIdorden() {
		return idorden;
	}
	public void setIdorden(String idorden) {
		this.idorden = idorden;
	}
	public String getIdpago() {
		return idpago;
	}
	public void setIdpago(String idpago) {
		this.idpago = idpago;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}

	public String getFecha_creado() {
		return fecha_creado;
	}

	public void setFecha_creado(String fecha_creado) {
		this.fecha_creado = fecha_creado;
	}

	public String getMonedapago() {
		return monedapago;
	}

	public void setMonedapago(String monedapago) {
		this.monedapago = monedapago;
	}
}
