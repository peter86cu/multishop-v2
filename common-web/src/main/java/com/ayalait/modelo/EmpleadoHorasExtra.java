package com.ayalait.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleado_horas_extras")
public class EmpleadoHorasExtra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String idempleado;
	private String fecha;
	private int horas;
	private int minutos;
	private int segundos;
	private String validado;
	private String aprobado;
	private int tipoausencia;
	private String estado;


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


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}


	public int getMinutos() {
		return minutos;
	}


	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}


	public int getSegundos() {
		return segundos;
	}


	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}


	public String getValidado() {
		return validado;
	}


	public void setValidado(String validado) {
		this.validado = validado;
	}


	public String getAprobado() {
		return aprobado;
	}


	public void setAprobado(String aprobado) {
		this.aprobado = aprobado;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public EmpleadoHorasExtra() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getTipoausencia() {
		return tipoausencia;
	}


	public void setTipoausencia(int tipoausencia) {
		this.tipoausencia = tipoausencia;
	}

}
