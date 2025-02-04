/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multishop.response;

import com.ayalait.utils.ErrorState;
import com.multishop.modelo.ShoppingUsuarios;

/**
 *
 * @author pedro
 */
public class ResponseUsuarioShopping {

    private boolean status;
    private int code;
    private ShoppingUsuarios user;
    private String resultado;
    private ErrorState error;



    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

	public ShoppingUsuarios getUser() {
		return user;
	}

	public void setUser(ShoppingUsuarios user) {
		this.user = user;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

   
    

}
