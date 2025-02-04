package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.TipoCuadre;
import com.ayalait.utils.ErrorState;

public class ResponseListaTipoCaudre {
	
	private boolean status;
    private int code;
    private List<TipoCuadre> tipoCaudre;
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

	public List<TipoCuadre> getTipoCaudre() {
		return tipoCaudre;
	}

	public void setTipoCaudre(List<TipoCuadre> tipoCaudre) {
		this.tipoCaudre = tipoCaudre;
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
