package com.ayalait.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeIdProcesarMarcas implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String idempleado;	
    private String fecha;
	public String getIdEmpleado() {
		return idempleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idempleado = idEmpleado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public CompositeIdProcesarMarcas() {
		super();
	}
	
    
    
}
