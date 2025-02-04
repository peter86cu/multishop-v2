package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Billetes;
import com.ayalait.utils.ErrorState;
import com.ayalait.utils.OCAprobadas;

public class ResponseListaPrefAprobadas {
	
	private boolean status;
    private int code;
    private List<OCAprobadas> prefacAprobadas;
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

	public List<OCAprobadas> getPrefacAprobadas() {
		return prefacAprobadas;
	}

	public void setPrefacAprobadas(List<OCAprobadas> prefacAprobadas) {
		this.prefacAprobadas = prefacAprobadas;
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
