package com.multishop.response;

import java.util.List;

import com.ayalait.utils.ErrorState;
import com.multishop.modelo.OrdenPago;


public class ResponseOrdenPago {
	
	private int code;
	private boolean status;
	private List<OrdenPago> lstOrdenPago;
	private String resultado;
	private ErrorState error;
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
	public List<OrdenPago> getLstOrdenPago() {
		return lstOrdenPago;
	}
	public void setLstOrdenPago(List<OrdenPago> lstOrdenPago) {
		this.lstOrdenPago = lstOrdenPago;
	}
	public ErrorState getError() {
		return error;
	}
	public void setError(ErrorState error) {
		this.error = error;
	}
	
	

}
