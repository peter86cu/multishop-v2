package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Cliente;
import com.ayalait.utils.ErrorState;
import com.multishop.modelo.Prefactura;

public class ResponsePrefactClient {
	
	private boolean status;
    private int code;
    private Prefactura prefactura;
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

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public Prefactura getPrefactura() {
		return prefactura;
	}

	public void setPrefactura(Prefactura prefactura) {
		this.prefactura = prefactura;
	}

	

}
