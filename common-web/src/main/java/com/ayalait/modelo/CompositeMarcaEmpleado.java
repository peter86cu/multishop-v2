package com.ayalait.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeMarcaEmpleado implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String idempleado;
	private String idmarca;
    private String fecha;

	public String getIdempleado() {
		return idempleado;
	}
	public void setIdempleado(String idempleado) {
		this.idempleado = idempleado;
	}
	public String getIdmarca() {
		return idmarca;
	}
	public void setIdmarca(String idmarca) {
		this.idmarca = idmarca;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
   
    
    
}
