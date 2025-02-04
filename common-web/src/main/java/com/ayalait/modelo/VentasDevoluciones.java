package com.ayalait.modelo;



public class VentasDevoluciones  {


	private String id_devolucion;
	private int id_venta;
	private String tipo_devolucion;
	private String causa;
	private String aprobado;
	private String efectuado;
	private String fecha;
	private double saldo_devuelto;

	public String getId_devolucion() {
		return id_devolucion;
	}

	public void setId_devolucion(String id_devolucion) {
		this.id_devolucion = id_devolucion;
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public String getTipo_devolucion() {
		return tipo_devolucion;
	}

	public void setTipo_devolucion(String tipo_devolucion) {
		this.tipo_devolucion = tipo_devolucion;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getAprobado() {
		return aprobado;
	}

	public void setAprobado(String aprobado) {
		this.aprobado = aprobado;
	}

	public String getEfectuado() {
		return efectuado;
	}

	public void setEfectuado(String efectuado) {
		this.efectuado = efectuado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getSaldo_devuelto() {
		return saldo_devuelto;
	}

	public void setSaldo_devuelto(double saldo_devuelto) {
		this.saldo_devuelto = saldo_devuelto;
	}
}
