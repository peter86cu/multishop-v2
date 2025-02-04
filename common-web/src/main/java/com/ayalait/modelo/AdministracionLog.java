package com.ayalait.modelo;




public class AdministracionLog  {
	
	
	
	private int id;
	private int id_administracion;
	private int id_estado;
	private String id_usuario_ejecuto;
	private String resultado;
	private String fecha_ejecucion;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_administracion() {
		return id_administracion;
	}


	public void setId_administracion(int id_administracion) {
		this.id_administracion = id_administracion;
	}


	public String getId_usuario_ejecuto() {
		return id_usuario_ejecuto;
	}


	public void setId_usuario_ejecuto(String id_usuario_ejecuto) {
		this.id_usuario_ejecuto = id_usuario_ejecuto;
	}


	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public String getFecha_ejecucion() {
		return fecha_ejecucion;
	}


	public void setFecha_ejecucion(String fecha_ejecucion) {
		this.fecha_ejecucion = fecha_ejecucion;
	}


	public AdministracionLog() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_estado() {
		return id_estado;
	}


	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}
	
}
