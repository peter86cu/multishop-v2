package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.TipoArqueo;
import com.ayalait.utils.ErrorState;

public class ResponseListaTipoArqueo {
	
	private boolean status;
    private int code;
    private List<TipoArqueo> tipoArqueo;
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

	public List<TipoArqueo> getTipoArqueo() {
		return tipoArqueo;
	}

	public void setTipoArqueo(List<TipoArqueo> tipoArqueo) {
		this.tipoArqueo = tipoArqueo;
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
