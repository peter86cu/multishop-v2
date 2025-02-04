package com.ayalait.modelo;

public class EstadoUsuarios  {
	
	private int id;
	private String estado;
	private String idmodulo;
	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getIdmodulo() {
		return idmodulo;
	}



	public void setIdmodulo(String idmodulo) {
		this.idmodulo = idmodulo;
	}



	public EstadoUsuarios(int id, String estado,String idmodulo) {
		super();
		this.id = id;
		this.estado = estado;
		this.idmodulo=idmodulo;
	}



	public EstadoUsuarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
