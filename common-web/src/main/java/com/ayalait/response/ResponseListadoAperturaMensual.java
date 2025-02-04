package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.AperturaCaja;
import com.ayalait.utils.ErrorState;

public class ResponseListadoAperturaMensual {
	
	private boolean status;
    private int code;
    private List<AperturaCaja> aperturaCaja;   
    private String resultado;
    private ErrorState error;

    

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

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

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public List<AperturaCaja> getAperturaCaja() {
		return aperturaCaja;
	}

	public void setAperturaCaja(List<AperturaCaja> aperturaCaja) {
		this.aperturaCaja = aperturaCaja;
	}    
	
	


}
