package com.ayalait.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="contable_calculo_costo")
public class CalculoCosto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String fecha;
	private int calculo;

	public CalculoCosto() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getCalculo() {
		return calculo;
	}


	public void setCalculo(int calculo) {
		this.calculo = calculo;
	}


	

	

}