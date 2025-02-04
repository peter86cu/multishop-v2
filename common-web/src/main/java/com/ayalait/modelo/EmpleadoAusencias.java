package com.ayalait.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleado_ausencias")
public class EmpleadoAusencias implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String idempleado;
	private String fecha;
	private int horas;
	private int minutos;
	private int segundos;
	private String registrado;
	private String aprobado;
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


	public String getRegistrado() {
		return registrado;
	}


	public void setRegistrado(String registrado) {
		this.registrado = registrado;
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


	public EmpleadoAusencias() {
		super();
		// TODO Auto-generated constructor stub
	}

}
