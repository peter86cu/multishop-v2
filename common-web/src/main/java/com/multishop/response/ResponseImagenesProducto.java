package com.multishop.response;


import java.util.List;

import com.ayalait.modelo.ProductoImagenes;
import com.ayalait.utils.ErrorState;

public class ResponseImagenesProducto {
	
	private int code;
	private boolean status;
	private String resultado;
	private List<ProductoImagenes> imagenProducto;
	private ErrorState error;

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
	
	public ResponseImagenesProducto() {
		super();

	}


	public List<ProductoImagenes> getImagenProducto() {
		return imagenProducto;
	}
	public void setImagenProducto(List<ProductoImagenes> imagenProducto) {
		this.imagenProducto = imagenProducto;
	}
	public ErrorState getError() {
		return error;
	}
	public void setError(ErrorState error) {
		this.error = error;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}


}
