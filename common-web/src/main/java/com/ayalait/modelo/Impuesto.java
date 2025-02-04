package com.ayalait.modelo;




public class Impuesto  {
	
	private int id_impuesto;
	private String descripcion;
	private int estado;
	private int aplicar;

	
	
	@Override
	public String toString() {
		return  descripcion ;
	}



	


	public int getId_impuesto() {
		return id_impuesto;
	}



	public void setId_impuesto(int id_impuesto) {
		this.id_impuesto = id_impuesto;
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



	public Impuesto() {
		super();
		// TODO Auto-generated constructor stub
	}






	public int getAplicar() {
		return aplicar;
	}






	public void setAplicar(int aplicar) {
		this.aplicar = aplicar;
	}
	
	
	
	

}
