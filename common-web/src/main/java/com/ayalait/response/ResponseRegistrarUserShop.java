package com.ayalait.response;

import com.ayalait.utils.ErrorState;

public class ResponseRegistrarUserShop {

	private boolean status;
	private int code;
	private String resultado;
	private ConfirmarRegistro confirmar;
	private ErrorState error;
	
	
	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public ConfirmarRegistro getConfirmar() {
		return confirmar;
	}


	public void setConfirmar(ConfirmarRegistro confirmar) {
		this.confirmar = confirmar;
	}


	public ErrorState getError() {
		return error;
	}


	public void setError(ErrorState error) {
		this.error = error;
	}


	public ResponseRegistrarUserShop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
