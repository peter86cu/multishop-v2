package com.ayalait.modelo;


public class HorarioTrabajo  {
	

	
	private int id;
	private String horario;
	private int estado;
	private String valor;
	private String horastrabajo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public HorarioTrabajo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getHorastrabajo() {
		return horastrabajo;
	}

	public void setHorastrabajo(String horastrabajo) {
		this.horastrabajo = horastrabajo;
	}

	

}
