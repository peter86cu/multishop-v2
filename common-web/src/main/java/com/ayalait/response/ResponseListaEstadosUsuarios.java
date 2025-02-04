/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.EstadoUsuarios;
import com.ayalait.utils.ErrorState;

/**
 *
 * @author pedro
 */
public class ResponseListaEstadosUsuarios {

	 private boolean status;
	    private int code;
	    private List<EstadoUsuarios> estados;
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
	   

		public List<EstadoUsuarios> getEstados() {
			return estados;
		}

		public void setEstados(List<EstadoUsuarios> estados) {
			this.estados = estados;
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
