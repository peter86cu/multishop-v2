package com.ayalait.modelo;

import java.io.Serializable;



public class AccionesGestion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int idaccion;

    private String accion;

    public AccionesGestion() {
    }

    public int getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(int idaccion) {
        this.idaccion = idaccion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    

}
