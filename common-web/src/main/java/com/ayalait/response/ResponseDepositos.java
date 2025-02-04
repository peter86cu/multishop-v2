package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Depositos;
import com.ayalait.utils.ErrorState;

public class ResponseDepositos {
	
	private boolean status;
    private int code;
    private List<Depositos> depositos;
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

	public List<Depositos> getDepositos() {
		return depositos;
	}

	public void setDepositos(List<Depositos> depositos) {
		this.depositos = depositos;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}


}
