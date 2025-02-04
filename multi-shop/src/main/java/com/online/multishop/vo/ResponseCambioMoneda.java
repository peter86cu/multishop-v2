package com.online.multishop.vo;

import java.util.List;

import com.ayalait.utils.ErrorState;

public class ResponseCambioMoneda {
	
	private boolean status;
	private int code;
	private List<CambioMoneda> cambio;
	private String respuesta;
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
	public List<CambioMoneda> getCambio() {
		return cambio;
	}
	public void setCambio(List<CambioMoneda> cambio) {
		this.cambio = cambio;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public ErrorState getError() {
		return error;
	}
	public void setError(ErrorState error) {
		this.error = error;
	}
	
	

}
