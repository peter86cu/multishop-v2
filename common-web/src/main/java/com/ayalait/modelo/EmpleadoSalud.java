package com.ayalait.modelo;

public class EmpleadoSalud {
	
	private int id;
	private String idempleado;
	private String nombreContacto;
    private int parentesco;
	private String contacto;
	private String vencimiento;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdempleado() {
		return idempleado;
	}
	public void setIdempleado(String idempleado) {
		this.idempleado = idempleado;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public int getParentesco() {
		return parentesco;
	}
	public void setParentesco(int parentesco) {
		this.parentesco = parentesco;
	}
	
	

}
