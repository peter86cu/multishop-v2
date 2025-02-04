package com.multishop.response;

 import java.util.List;

import com.ayalait.utils.ErrorState;

 
public class ResponseCartUsuario {

	private boolean status;
	private int code;
	private List<CarritoDetalle> cartDetalle;
	private ErrorState error;

	

	public ResponseCartUsuario() {
		super();
		// TODO Auto-generated constructor stub
		// this.detalle= null;
		// this.cart= null;
	}

	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<CarritoDetalle> getCartDetalle() {
		return cartDetalle;
	}

	public void setCartDetalle(List<CarritoDetalle> cartDetalle) {
		this.cartDetalle = cartDetalle;
	}
	
	

}
