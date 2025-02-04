/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.Modulos;
import com.ayalait.modelo.User;
import com.ayalait.utils.ErrorState;

/**
 *
 * @author pedro
 */
public class ResponseUsuario {

    private boolean status;
    private int code;
    private User user;
    private String resultado;
    private int rol;
    private List<Modulos> modulos;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   

    public List<Modulos> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulos> modulos) {
		this.modulos = modulos;
	}

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    

}
