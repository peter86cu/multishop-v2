package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.CentroCosto;
import com.ayalait.utils.ErrorState;

public class ResponseListaCentroCosto {
	
	private boolean status;
    private int code;
    private List<CentroCosto> centroCosto; 
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

	public List<CentroCosto> getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(List<CentroCosto> centroCosto) {
		this.centroCosto = centroCosto;
	}
	
	


}
