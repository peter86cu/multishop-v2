package com.ayalait.utils;

import java.io.Serializable;


import javax.persistence.Embeddable;

@Embeddable
public class CompositeIdMarcasEmpleado implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String idempleado;
    private String fecha;
	private String idmarca;

	public String getIdempleado() {
		return idempleado;
	}
	public void setIdempleado(String idempleado) {
		this.idempleado = idempleado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public CompositeIdMarcasEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdmarca() {
		return idmarca;
	}
	public void setIdmarca(String idmarca) {
		this.idmarca = idmarca;
	}
	
    
    
}
