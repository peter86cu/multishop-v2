package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.VentasCausaDevueltos;
import com.ayalait.utils.ErrorState;

public class ResponseListaEstadoVentasDevueltos {
	
	private boolean status;
    private int code;
    private List<VentasCausaDevueltos> causaDevueltos;
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

	

	public List<VentasCausaDevueltos> getCausaDevueltos() {
		return causaDevueltos;
	}

	public void setCausaDevueltos(List<VentasCausaDevueltos> causaDevueltos) {
		this.causaDevueltos = causaDevueltos;
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
