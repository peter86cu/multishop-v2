package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Plazos;
import com.ayalait.utils.ErrorState;

public class ResponsePlazos {
	
	private boolean status;
    private int code;
    private List<Plazos> plazos;
    private ErrorState error;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

	public List<Plazos> getPlazos() {
		return plazos;
	}

	public void setPlazos(List<Plazos> plazos) {
		this.plazos = plazos;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	


}
