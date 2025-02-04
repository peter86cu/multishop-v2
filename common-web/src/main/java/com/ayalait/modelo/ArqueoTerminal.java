package com.ayalait.modelo;



public class ArqueoTerminal  {
	
	private int idArqueo;
	private String fechaBaja;	
	private String fechaHoraCierre;	
	private int idAperturaCajero;
	private int idCuadre;
	private String fechaHora;
	private int idEstadoArqueo;
	private int idSucursal;
	private String idUsuario;

	public ArqueoTerminal() {
	}

	public int getIdArqueo() {
		return this.idArqueo;
	}

	public void setIdArqueo(int idArqueo) {
		this.idArqueo = idArqueo;
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

	public int getIdAperturaCajero() {
		return this.idAperturaCajero;
	}

	public void setIdAperturaCajero(int idAperturaCajero) {
		this.idAperturaCajero = idAperturaCajero;
	}

	public int getIdCuadre() {
		return this.idCuadre;
	}

	public void setIdCuadre(int idCuadre) {
		this.idCuadre = idCuadre;
	}

	public int getIdEstadoArqueo() {
		return this.idEstadoArqueo;
	}

	public void setIdEstadoArqueo(int idEstadoArqueo) {
		this.idEstadoArqueo = idEstadoArqueo;
	}

	public int getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFechaHoraCierre() {
		return fechaHoraCierre;
	}

	public void setFechaHoraCierre(String fechaHoraCierre) {
		this.fechaHoraCierre = fechaHoraCierre;
	}

}