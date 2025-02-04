package com.ayalait.modelo;

import java.io.Serializable;

public class AperturasTerminal implements Serializable  {
	 private static final long serialVersionUID = 1L;

	private int idAperturaCajero;

	private String fechaBaja;

	private String fechaHora;

	private String fechaHoraCierre;

	private String fechaInicio;

	private String horaInicio;

	private String idAperturaDia;

	private int idCaja;

	private int idTipoArqueo;

	private int idTurno;

	private int idUsuarioAlta;

	private int nroConsecutivo;

	private String idUsuario;

	private int idSucursal;
	
	
	
	public AperturasTerminal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdAperturaCajero() {
		return idAperturaCajero;
	}


	public void setIdAperturaCajero(int idAperturaCajero) {
		this.idAperturaCajero = idAperturaCajero;
	}


	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getIdSucursal() {
		return idSucursal;
	}


	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}


	public String getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getFechaHoraCierre() {
		return this.fechaHoraCierre;
	}

	public void setFechaHoraCierre(String fechaHoraCierre) {
		this.fechaHoraCierre = fechaHoraCierre;
	}

	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getIdAperturaDia() {
		return this.idAperturaDia;
	}

	public void setIdAperturaDia(String idAperturaDia) {
		this.idAperturaDia = idAperturaDia;
	}

	public int getIdCaja() {
		return this.idCaja;
	}

	public void setIdCaja(int idCaja) {
		this.idCaja = idCaja;
	}

	public int getIdTipoArqueo() {
		return this.idTipoArqueo;
	}

	public void setIdTipoArqueo(int idTipoArqueo) {
		this.idTipoArqueo = idTipoArqueo;
	}

	public int getIdTurno() {
		return this.idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public int getIdUsuarioAlta() {
		return this.idUsuarioAlta;
	}

	public void setIdUsuarioAlta(int idUsuarioAlta) {
		this.idUsuarioAlta = idUsuarioAlta;
	}

	public int getNroConsecutivo() {
		return this.nroConsecutivo;
	}

	public void setNroConsecutivo(int nroConsecutivo) {
		this.nroConsecutivo = nroConsecutivo;
	}

	
}