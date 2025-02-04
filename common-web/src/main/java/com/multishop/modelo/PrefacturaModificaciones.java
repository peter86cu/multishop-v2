package com.multishop.modelo;

import javax.persistence.*;

import java.io.Serializable;



@Entity
@Table(name="prefacturas_modificaciones")
public class PrefacturaModificaciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_prefactura_modif;	
	private String id_prefactura;	
	private String id_usuario_autorizo;	
	private String id_usuario_cancela;
	private String id_usuario_envio;	
	private String fecha_autorizo;
	private String fecha_cancela;
	private String fecha_envio;
	
	public int getId_prefactura_modif() {
		return id_prefactura_modif;
	}
	public void setId_prefactura_modif(int id_prefactura_modif) {
		this.id_prefactura_modif = id_prefactura_modif;
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
	public String getId_prefactura() {
		return id_prefactura;
	}
	public void setId_prefactura(String id_prefactura) {
		this.id_prefactura = id_prefactura;
	}
	public PrefacturaModificaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId_usuario_cancela() {
		return id_usuario_cancela;
	}
	public void setId_usuario_cancela(String id_usuario_cancela) {
		this.id_usuario_cancela = id_usuario_cancela;
	}
	public String getFecha_cancela() {
		return fecha_cancela;
	}
	public void setFecha_cancela(String fecha_cancela) {
		this.fecha_cancela = fecha_cancela;
	}
	
	
	
}
