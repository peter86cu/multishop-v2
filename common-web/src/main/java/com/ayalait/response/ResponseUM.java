package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.UnidadMedida;
import com.ayalait.utils.ErrorState;
public class ResponseUM {
	
	private boolean status;
    private int code;
    private List<UnidadMedida> um;
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
    
	

	public List<UnidadMedida> getUm() {
		return um;
	}

	public void setUm(List<UnidadMedida> um) {
		this.um = um;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	

}
