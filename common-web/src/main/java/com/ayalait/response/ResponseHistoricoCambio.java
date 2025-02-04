package com.ayalait.response;

import com.ayalait.modelo.HistoricoCambio;
import com.ayalait.utils.ErrorState;

public class ResponseHistoricoCambio {
	
	private boolean status;
    private int code;
    private HistoricoCambio historicoCambio;
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

	public HistoricoCambio getHistoricoCambio() {
		return historicoCambio;
	}

	public void setHistoricoCambio(HistoricoCambio historicoCambio) {
		this.historicoCambio = historicoCambio;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}


}
