package com.ayalait.response;

import com.ayalait.utils.ErrorState;
import com.multishop.modelo.PrefacturaModificaciones;

public class ResponseMofPorIdPrefactura {

    private boolean status;
    private int code;
    private PrefacturaModificaciones modificaciones;
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

	public PrefacturaModificaciones getModificaciones() {
		return modificaciones;
	}

	public void setModificaciones(PrefacturaModificaciones modificaciones) {
		this.modificaciones = modificaciones;
	}

}
