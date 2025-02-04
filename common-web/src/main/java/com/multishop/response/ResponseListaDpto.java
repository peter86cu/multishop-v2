package com.multishop.response;

import java.util.List;

import com.ayalait.utils.ErrorState;
import com.multishop.modelo.DptoPais;

public class ResponseListaDpto {
	private int code;
	private boolean status;
	private String resultado;
	private ErrorState error;
    private List<DptoPais> dpto;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public List<DptoPais> getDpto() {
		return dpto;
	}
	public void setDpto(List<DptoPais> dpto) {
		this.dpto = dpto;
	}
	 
    
    
	
}

