package com.ayalait.modelo;



public class HorarioLaboral  {
	
	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idHorario;

	private String diaSemana;

	private String horaInicio;

	private String horaFin;

	private int trabaja;

	private int dia;
	private int mes;
	private int annio;

	private CalendarioEmpleado calendarioEmpleado;

	public String getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(String idHorario) {
		this.idHorario = idHorario;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public CalendarioEmpleado getCalendarioEmpleado() {
		return calendarioEmpleado;
	}

	public void setCalendarioEmpleado(CalendarioEmpleado calendarioEmpleado) {
		this.calendarioEmpleado = calendarioEmpleado;
	}

	public int isTrabaja() {
		return trabaja;
	}

	public void setTrabaja(int trabaja) {
		this.trabaja = trabaja;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnnio() {
		return annio;
	}

	public void setAnnio(int annio) {
		this.annio = annio;
	}

}
