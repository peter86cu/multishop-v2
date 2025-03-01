/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.multishop.vo;

import com.ayalait.modelo.Ventas;
import com.ayalait.utils.ErrorState;

/**
 *
 * @author pedro
 */
public class ResponseVenta {

	private boolean status;
	private int code;
	private String resultado;
	private Ventas venta;
	private String temporal;
	private ErrorState error;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
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

	public String getTemporal() {
		return temporal;
	}

	public void setTemporal(String temporal) {
		this.temporal = temporal;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public Ventas getVenta() {
		return venta;
	}

	public void setVenta(Ventas venta) {
		this.venta = venta;
	}
}
