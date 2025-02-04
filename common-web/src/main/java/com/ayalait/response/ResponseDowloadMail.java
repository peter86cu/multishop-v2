package com.ayalait.response;

import com.ayalait.utils.ErrorState;

public class ResponseDowloadMail {
	
	private boolean status;
    private int code;
    private CorreosDowload lstMail;
    private ErrorState error;

    private String resultado;

    public CorreosDowload getLstMail() {
        return lstMail;
    }

    public void setLstMail(CorreosDowload lstMail) {
        this.lstMail = lstMail;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }


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


}
