package com.multishop.response;



public class ResponseCarritoDetalle {
	
	private int code;
	private String resultado;
	private ResponseCart datosCart;

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public ResponseCarritoDetalle() {
		super();
		this.datosCart=null;

	}

	public ResponseCart getDatosCart() {
		return datosCart;
	}

	public void setDatosCart(ResponseCart datosCart) {
		this.datosCart = datosCart;
	}


}
