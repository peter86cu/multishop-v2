/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.TipoDocumento;
import com.ayalait.utils.ErrorState;

/**
 *
 * @author pedro
 */
public class ResponseListaTipoDoc {

    private boolean status;
    private int code;
    private List<TipoDocumento> documento;
    private String resultado;
    private ErrorState error;
    
    
    
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

    


	public List<TipoDocumento> getDocumento() {
		return documento;
	}

	public void setDocumento(List<TipoDocumento> documento) {
		this.documento = documento;
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

}
