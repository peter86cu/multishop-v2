package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Paises;
import com.ayalait.utils.ErrorState;
public class ResponseListaPaises {

	private boolean status;
	private int code;
	private List<Paises> paises;
	private String resultado;
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

	

	public List<Paises> getPaises() {
		return paises;
	}

	public void setPaises(List<Paises> paises) {
		this.paises = paises;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

}
