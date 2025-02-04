package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Departamentos;
import com.ayalait.utils.ErrorState;

public class ResponseListaDepartamentos {
	
	private boolean status;
    private int code;
    private List<Departamentos> departamentos;   
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

	

	public List<Departamentos> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamentos> departamentos) {
		this.departamentos = departamentos;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}
	
	


}
