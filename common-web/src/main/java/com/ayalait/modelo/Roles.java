package com.ayalait.modelo;

import java.util.ArrayList;
import java.util.List;

public class Roles  {
	
	 private int idrol;
	    private String descripcion;
	   // private List<Modulos> modulos = new ArrayList<>();

	    public int getIdrol() {
	        return idrol;
	    }

	    public void setIdrol(int idrol) {
	        this.idrol = idrol;
	    }

	    

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public Roles(int idrol, String descripcion) {
	        this.idrol = idrol;
	        this.descripcion = descripcion;
	    }

	/*    public List<Modulos> getModulos() {
	        return modulos;
	    }

	    public void setModulos(List<Modulos> modulos) {
	        this.modulos = modulos;
	    }

	   
*/
	    public Roles() {
	    }

	    @Override
	    public String toString() {
	        return descripcion;
	    }
	

}