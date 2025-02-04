package com.multishop.response;

import java.util.Map;



public class ResultadoDetalleProducto {

	private String resena;
	private String caracteristica;
	private Map<String, String> mapa;
	public String getResena() {
		return resena;
	}
	public void setResena(String resena) {
		this.resena = resena;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	public Map<String, String> getMapa() {
		return mapa;
	}
	public void setMapa(Map<String, String> mapa) {
		this.mapa = mapa;
	}
	

	

}
