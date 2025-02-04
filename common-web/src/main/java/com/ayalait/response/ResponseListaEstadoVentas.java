package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.VentasEstados;
import com.ayalait.utils.ErrorState;

public class ResponseListaEstadoVentas {
	
	private boolean status;
    private int code;
    private List<VentasEstados> estadoVentas;
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

	

	public List<VentasEstados> getEstadoVentas() {
		return estadoVentas;
	}

	public void setEstadoVentas(List<VentasEstados> estadoVentas) {
		this.estadoVentas = estadoVentas;
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
