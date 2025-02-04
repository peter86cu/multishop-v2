package com.ayalait.modelo;


public class UnidadMedida {
	
	private int id_unidad_medida;
	private String nombre;
	private String simbolo;
	private int conversion;


	public int getId_unidad_medida() {
		return id_unidad_medida;
	}





	public void setId_unidad_medida(int id_unidad_medida) {
		this.id_unidad_medida = id_unidad_medida;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getSimbolo() {
		return simbolo;
	}





	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}





	public int getConversion() {
		return conversion;
	}





	public void setConversion(int conversion) {
		this.conversion = conversion;
	}





	@Override
	public String toString() {
		return  nombre +" "+simbolo;
	}





	public UnidadMedida() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
