package com.multishop.modelo;

public class OrdenPago {
 
	private String order_id;
	private String idpago;
	private int monto;
	private int iva;
	private String fecha_pago;
	private String state;
	private String idusuario;
	private String idcart;
	private int iddireccion;

	private String monedapago;
	private String redirect_url;

	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
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
	
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getIdcart() {
		return idcart;
	}
	public void setIdcart(String idcart) {
		this.idcart = idcart;
	}
	public String getIdpago() {
		return idpago;
	}
	public void setIdpago(String idpago) {
		this.idpago = idpago;
	}
	public String getRedirect_url() {
		return redirect_url;
	}
	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}

	public String getMonedapago() {
		return monedapago;
	}

	public void setMonedapago(String monedapago) {
		this.monedapago = monedapago;
	}
	public int getIddireccion() {
		return iddireccion;
	}
	public void setIddireccion(int iddireccion) {
		this.iddireccion = iddireccion;
	}
}
