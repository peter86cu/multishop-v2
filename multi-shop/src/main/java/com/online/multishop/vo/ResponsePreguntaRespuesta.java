package com.online.multishop.vo;

import java.util.List;

import com.ayalait.utils.ErrorState;
import com.online.multishop.dto.PreguntaRespuesta;

public class ResponsePreguntaRespuesta {
	
	private boolean status;
	private int code;
	private List<PreguntaRespuesta> preguntasRespuestas;
	private String respuesta;
	private ErrorState error;
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
	
	public List<PreguntaRespuesta> getPreguntasRespuestas() {
		return preguntasRespuestas;
	}
	public void setPreguntasRespuestas(List<PreguntaRespuesta> preguntasRespuestas) {
		this.preguntasRespuestas = preguntasRespuestas;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public ErrorState getError() {
		return error;
	}
	public void setError(ErrorState error) {
		this.error = error;
	}
	
	

}
