package com.multishop.response;

 

import com.ayalait.utils.ErrorState;


public class ResponseCart {

	private boolean status;
	private int code;
	private CarritoDetalle cartDetalle;
	private ErrorState error;

	

	public ResponseCart() {
		super();
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

	
	
	public CarritoDetalle getCartDetalle() {
		return cartDetalle;
	}

	public void setCartDetalle(CarritoDetalle cartDetalle) {
		this.cartDetalle = cartDetalle;
	}
	
	

}
