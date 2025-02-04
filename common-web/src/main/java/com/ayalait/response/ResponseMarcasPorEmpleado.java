package com.ayalait.response;

import com.ayalait.modelo.MarcasEmpleado;
import com.ayalait.utils.ErrorState;

public class ResponseMarcasPorEmpleado {

    private boolean status;
    private int code;
    private MarcasEmpleado marcas;
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

  
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public MarcasEmpleado getMarcas() {
		return marcas;
	}

	public void setMarcas(MarcasEmpleado marcas) {
		this.marcas = marcas;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

}
