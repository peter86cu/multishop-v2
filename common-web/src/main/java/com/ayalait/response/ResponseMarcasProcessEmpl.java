package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Banco;
import com.ayalait.utils.ErrorState;
import com.ayalait.utils.MarcaEmpleadoProcess;

public class ResponseMarcasProcessEmpl {

	private boolean status;
	private int code;
	private List<MarcaEmpleadoProcess> process;
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

	public List<MarcaEmpleadoProcess> getProcess() {
		return process;
	}

	public void setProcess(List<MarcaEmpleadoProcess> process) {
		this.process = process;
	}

	
}
