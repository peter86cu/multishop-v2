package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.AdjuntoMail;
import com.ayalait.modelo.Inbox;

public class Correo {
	
	private Inbox correo;
	private List<AdjuntoMail> adjuntos;
	public Inbox getCorreo() {
		return correo;
	}
	public void setCorreo(Inbox correo) {
		this.correo = correo;
	}
	public List<AdjuntoMail> getAdjuntos() {
		return adjuntos;
	}
	public void setAdjuntos(List<AdjuntoMail> adjuntos) {
		this.adjuntos = adjuntos;
	}
	
	

}
