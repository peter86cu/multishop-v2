package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Billetes;
import com.ayalait.utils.ErrorState;

public class ResponseListaBilletes {
	
	private boolean status;
    private int code;
    private List<Billetes> billetes;
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
	
	

	public List<Billetes> getBilletes() {
		return billetes;
	}

	public void setBilletes(List<Billetes> billetes) {
		this.billetes = billetes;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


}
