package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Banco;
import com.ayalait.modelo.TipoGastos;
import com.ayalait.utils.ErrorState;

public class ResponseListaTipoGastos {

	private boolean status;
	private int code;
	private List<TipoGastos> tipoGasto;
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

	

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public List<TipoGastos> getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(List<TipoGastos> tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

}
