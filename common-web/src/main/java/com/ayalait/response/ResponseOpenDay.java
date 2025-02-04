package com.ayalait.response;

import java.util.List;

import com.ayalait.utils.DiaAbierto;
import com.ayalait.utils.ErrorState;

public class ResponseOpenDay {
	
	private boolean status;
    private int code;
    private List<DiaAbierto> open;
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

	public List<DiaAbierto> getOpen() {
		return open;
	}

	public void setOpen(List<DiaAbierto> open) {
		this.open = open;
	}


}
