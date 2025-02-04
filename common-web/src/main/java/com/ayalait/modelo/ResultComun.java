package com.ayalait.modelo;

public class ResultComun {
	
	private int id;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ResultComun(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
     @Override
    public String toString() {
        return descripcion;
    }

}
