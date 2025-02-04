package com.ayalait.modelo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "marcas_procesadas")
public class MarcasProcesadas implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompositeMarcaEmpleado compositeId;
	private int horasprocesadas;
	private int minutosprocesados;
	private int segundosprocesados;
	private String estado;

	
	public CompositeMarcaEmpleado getCompositeId() {
		return compositeId;
	}

	public void setCompositeId(CompositeMarcaEmpleado compositeId) {
		this.compositeId = compositeId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public MarcasProcesadas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getHorasprocesadas() {
		return horasprocesadas;
	}

	public void setHorasprocesadas(int horasprocesadas) {
		this.horasprocesadas = horasprocesadas;
	}

	public int getMinutosprocesados() {
		return minutosprocesados;
	}

	public void setMinutosprocesados(int minutosprocesados) {
		this.minutosprocesados = minutosprocesados;
	}

	public int getSegundosprocesados() {
		return segundosprocesados;
	}

	public void setSegundosprocesados(int segundosprocesados) {
		this.segundosprocesados = segundosprocesados;
	}

	

	/*@Override
	public String toString() {
		return "MarcasProcesadas{" + "id=" + getCompositeId().getIdEmpleado() + ", horasProcesadas=" + horasprocesadas + ", fecha=" + getCompositeId().getFecha()
				+ ", estado=" + estado + '}';
	}*/

}
