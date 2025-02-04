package com.ayalait.modelo;


public class Billetes {
	
	
	private String id_billete;
	private double monto;
	private int id_moneda;
	private String descripcion;	
	public String getId_billete() {
		return id_billete;
	}
	public void setId_billete(String id_billete) {
		this.id_billete = id_billete;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getId_moneda() {
		return id_moneda;
	}
	public void setId_moneda(int id_moneda) {
		this.id_moneda = id_moneda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	private int estado;

	
}