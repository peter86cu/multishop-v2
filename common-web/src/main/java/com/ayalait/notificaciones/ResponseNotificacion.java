package com.ayalait.notificaciones;

import java.util.List;

import com.ayalait.modelo.Caja;
import com.ayalait.utils.ErrorState;

public class ResponseNotificacion {
	
	private boolean status;
    private int code;
    private List<Notificaciones> notificaciones;
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

	public List<Notificaciones> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificaciones> notificaciones) {
		this.notificaciones = notificaciones;
	}


}
