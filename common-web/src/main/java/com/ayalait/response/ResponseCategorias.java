package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Categoria;
import com.ayalait.utils.ErrorState;
public class ResponseCategorias {
	
	private boolean status;
    private int code;
    private List<Categoria> categorias;
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
    
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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
