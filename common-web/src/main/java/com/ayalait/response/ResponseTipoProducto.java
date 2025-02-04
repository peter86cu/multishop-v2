package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.TipoProducto;
import com.ayalait.utils.ErrorState;

public class ResponseTipoProducto {

	private boolean status;
	private int code;
	private List<TipoProducto> tipoProductos;
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

	

	public List<TipoProducto> getTipoProductos() {
		return tipoProductos;
	}

	public void setTipoProductos(List<TipoProducto> tipoProductos) {
		this.tipoProductos = tipoProductos;
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

}
