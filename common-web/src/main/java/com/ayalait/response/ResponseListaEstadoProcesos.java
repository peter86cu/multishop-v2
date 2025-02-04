package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.EstadoProceso;
import com.ayalait.utils.ErrorState;

public class ResponseListaEstadoProcesos {

	private boolean status;
	private int code;
	private List<EstadoProceso> estado;
	private ErrorState error;
	private String resultado;

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

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public List<EstadoProceso> getEstado() {
		return estado;
	}

	public void setEstado(List<EstadoProceso> estado) {
		this.estado = estado;
	}

}
