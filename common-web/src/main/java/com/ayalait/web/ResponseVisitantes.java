package com.ayalait.web;

import java.util.List;

import com.ayalait.utils.ErrorState;

public class ResponseVisitantes {
	 private boolean status;
	    private int code;
	    private List<VisitantesLog> visitantes;
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
		public List<VisitantesLog> getVisitantes() {
			return visitantes;
		}
		public void setVisitantes(List<VisitantesLog> visitantes) {
			this.visitantes = visitantes;
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
