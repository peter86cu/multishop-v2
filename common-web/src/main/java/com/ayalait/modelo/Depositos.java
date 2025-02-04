package com.ayalait.modelo;



public class Depositos  {

	private int id_deposito;	
	private String descripcion;
	private String id_sucursal;
	private String fecha_baja;

	
	public int getId_deposito() {
		return id_deposito;
	}


	public void setId_deposito(int id_deposito) {
		this.id_deposito = id_deposito;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getId_sucursal() {
		return id_sucursal;
	}


	public void setId_sucursal(String id_sucursal) {
		this.id_sucursal = id_sucursal;
	}


	public String getFecha_baja() {
		return fecha_baja;
	}


	public void setFecha_baja(String fecha_baja) {
		this.fecha_baja = fecha_baja;
	}


	public Depositos() {
		super();
	}





	
}