package com.ayalait.modelo;


public class OrdenCompraModificaciones  {

	
	private int id_orden_modif;	
	private int id_orden_compra;	
	private String id_usuario_autorizo;	
	private String id_usuario_envio;	
	private String fecha_autorizo;	
	private String fecha_envio;
	public int getId_orden_modif() {
		return id_orden_modif;
	}
	public void setId_orden_modif(int id_orden_modif) {
		this.id_orden_modif = id_orden_modif;
	}
	public int getId_orden_compra() {
		return id_orden_compra;
	}
	public void setId_orden_compra(int id_orden_compra) {
		this.id_orden_compra = id_orden_compra;
	}
	public String getId_usuario_autorizo() {
		return id_usuario_autorizo;
	}
	public void setId_usuario_autorizo(String id_usuario_autorizo) {
		this.id_usuario_autorizo = id_usuario_autorizo;
	}
	public String getId_usuario_envio() {
		return id_usuario_envio;
	}
	public void setId_usuario_envio(String id_usuario_envio) {
		this.id_usuario_envio = id_usuario_envio;
	}
	public String getFecha_autorizo() {
		return fecha_autorizo;
	}
	public void setFecha_autorizo(String fecha_autorizo) {
		this.fecha_autorizo = fecha_autorizo;
	}
	public String getFecha_envio() {
		return fecha_envio;
	}
	public void setFecha_envio(String fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	
	
	
}
