package com.ayalait.modelo;


public class OrdenCompra {

	private int id_orden_compra;

	private String fecha_hora;

	private int estado;

	private String id_usuario;

	private int id_sucursal;

	private int id_plazo;

	private int id_forma_pago;

	private int id_proveedor;

	private String fecha_baja;

	private int id_cotizacion_producto;

	private String fecha_hora_creado;

	public int getId_orden_compra() {
		return id_orden_compra;
	}

	public void setId_orden_compra(int id_orden_compra) {
		this.id_orden_compra = id_orden_compra;
	}

	public String getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(int id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public int getId_plazo() {
		return id_plazo;
	}

	public void setId_plazo(int id_plazo) {
		this.id_plazo = id_plazo;
	}

	public int getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(int id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(String fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public int getId_cotizacion_producto() {
		return id_cotizacion_producto;
	}

	public void setId_cotizacion_producto(int id_cotizacion_producto) {
		this.id_cotizacion_producto = id_cotizacion_producto;
	}

	public String getFecha_hora_creado() {
		return fecha_hora_creado;
	}

	public void setFecha_hora_creado(String fecha_hora_creado) {
		this.fecha_hora_creado = fecha_hora_creado;
	}
	
	
	

}
