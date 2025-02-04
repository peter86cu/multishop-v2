/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayalait.response;

import com.ayalait.modelo.AperturaCaja;
import com.ayalait.utils.ErrorState;

public class ResponseValidarEstadoCaja {

    private boolean status;
    private int code;
    private AperturaCaja apertura;
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

	public AperturaCaja getApertura() {
		return apertura;
	}

	public void setApertura(AperturaCaja apertura) {
		this.apertura = apertura;
	}

}
