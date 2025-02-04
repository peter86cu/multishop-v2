package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.ItemsVenta;
import com.ayalait.utils.ErrorState;

public class ResponseItemsVentas {
	
	private boolean status;
    private int code;
    private List<ItemsVenta> itemsVentas;
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
	
	

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<ItemsVenta> getItemsVentas() {
		return itemsVentas;
	}

	public void setItemsVentas(List<ItemsVenta> itemsVentas) {
		this.itemsVentas = itemsVentas;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}


}
