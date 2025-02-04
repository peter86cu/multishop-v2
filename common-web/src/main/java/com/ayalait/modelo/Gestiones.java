package com.ayalait.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Gestiones implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idgestion;
    private String nombre;   
    private List<AccionesGestion> accion = new ArrayList<>();

    public int getIdgestion() {
        return idgestion;
    }

    public void setIdgestion(int idgestion) {
        this.idgestion = idgestion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AccionesGestion> getAccion() {
        return accion;
    }

    public void setAccion(List<AccionesGestion> accion) {
        this.accion = accion;
    }

}
