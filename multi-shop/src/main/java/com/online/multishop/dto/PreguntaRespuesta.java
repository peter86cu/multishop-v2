package com.online.multishop.dto;

import java.sql.Timestamp;

import com.online.multishop.CustomTimestampDeserializer;
import com.ayalait.modelo.Producto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.multishop.modelo.ShoppingUsuarios;

public class PreguntaRespuesta {

	private int idPregunta;

	private String idProducto;
	private String idUsuarioPregunta;
	private String idUsuarioRespuesta;
	private String pregunta;
	private String respuesta;
	@JsonDeserialize(using = CustomTimestampDeserializer.class)
	private Timestamp fechaPregunta;
	@JsonDeserialize(using = CustomTimestampDeserializer.class)
	private Timestamp fechaRespuesta;
	private int estado; // 0 = Sin responder, 1 = Respondida

	private Producto producto;

	private ShoppingUsuarios usuarioPregunta;

	private ShoppingUsuarios usuarioRespuesta;

	public String getIdUsuarioPregunta() {
		return idUsuarioPregunta;
	}

	public void setIdUsuarioPregunta(String idUsuarioPregunta) {
		this.idUsuarioPregunta = idUsuarioPregunta;
	}

	public String getIdUsuarioRespuesta() {
		return idUsuarioRespuesta;
	}

	public void setIdUsuarioRespuesta(String idUsuarioRespuesta) {
		this.idUsuarioRespuesta = idUsuarioRespuesta;
	}

	public ShoppingUsuarios getUsuarioPregunta() {
		return usuarioPregunta;
	}

	public void setUsuarioPregunta(ShoppingUsuarios usuarioPregunta) {
		this.usuarioPregunta = usuarioPregunta;
	}

	public ShoppingUsuarios getUsuarioRespuesta() {
		return usuarioRespuesta;
	}

	public void setUsuarioRespuesta(ShoppingUsuarios usuarioRespuesta) {
		this.usuarioRespuesta = usuarioRespuesta;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Timestamp getFechaPregunta() {
		return fechaPregunta;
	}

	public void setFechaPregunta(Timestamp fechaPregunta) {
		this.fechaPregunta = fechaPregunta;
	}

	public Timestamp getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Timestamp fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
