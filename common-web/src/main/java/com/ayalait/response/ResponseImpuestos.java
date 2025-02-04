package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Impuesto;
import com.ayalait.utils.ErrorState;

public class ResponseImpuestos {
	
	private boolean status;
    private int code;
    private List<Impuesto> impuestos;
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

	public List<Impuesto> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(List<Impuesto> impuestos) {
		this.impuestos = impuestos;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}


}
