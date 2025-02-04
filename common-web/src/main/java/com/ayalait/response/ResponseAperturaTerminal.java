package com.ayalait.response;

import com.ayalait.modelo.AperturasTerminal;
import com.ayalait.modelo.ResponseApertura;
import com.ayalait.utils.ErrorState;

public class ResponseAperturaTerminal {
	

    private boolean status;
    private int code;
    private AperturasTerminal terminal;
    private ErrorState error;
    private String resultado;

    private ResponseApertura terminalCierre;

    public ResponseApertura getTerminalCierre() {
        return terminalCierre;
    }

    public void setTerminalCierre(ResponseApertura terminalCierre) {
        this.terminalCierre = terminalCierre;
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

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public AperturasTerminal getTerminal() {
		return terminal;
	}

	public void setTerminal(AperturasTerminal terminal) {
		this.terminal = terminal;
	}

	

}
