package com.ayalait.modelo;




public class ArqueosDetalle {
	

	private int idArqueoDetalle;

	
	private int idArqueo;

	
	private int idBillete;

	private int valor;

	public ArqueosDetalle() {
	}

	public int getIdArqueoDetalle() {
		return this.idArqueoDetalle;
	}

	public void setIdArqueoDetalle(int idArqueoDetalle) {
		this.idArqueoDetalle = idArqueoDetalle;
	}

	public int getIdArqueo() {
		return this.idArqueo;
	}

	public void setIdArqueo(int idArqueo) {
		this.idArqueo = idArqueo;
	}

	public int getIdBillete() {
		return this.idBillete;
	}

	public void setIdBillete(int idBillete) {
		this.idBillete = idBillete;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}