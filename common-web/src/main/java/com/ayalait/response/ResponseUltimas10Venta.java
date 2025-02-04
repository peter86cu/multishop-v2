package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Ventas;
import com.ayalait.utils.ErrorState;

public class ResponseUltimas10Venta {
	
	private boolean status;
    private int code;
    private List<Ventas> venta;
    private String userVendedor; 
    private String userAprueba;
    private String resultado;
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
    
	
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	

	public String getUserVendedor() {
		return userVendedor;
	}

	public void setUserVendedor(String userVendedor) {
		this.userVendedor = userVendedor;
	}

	public String getUserAprueba() {
		return userAprueba;
	}

	public void setUserAprueba(String userAprueba) {
		this.userAprueba = userAprueba;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public List<Ventas> getVenta() {
		return venta;
	}

	public void setVenta(List<Ventas> venta) {
		this.venta = venta;
	}

	
	


}
