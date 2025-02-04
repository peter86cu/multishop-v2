package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Caja;
import com.ayalait.utils.ErrorState;
import com.ayalait.utils.ResponsePrefactura;

public class ResponseListaPrefactura {
	
	private boolean status;
    private int code;
    private List<ResponsePrefactura> lstPrefacturas;
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

	public List<ResponsePrefactura> getLstPrefacturas() {
		return lstPrefacturas;
	}

	public void setLstPrefacturas(List<ResponsePrefactura> lstPrefacturas) {
		this.lstPrefacturas = lstPrefacturas;
	}


}
