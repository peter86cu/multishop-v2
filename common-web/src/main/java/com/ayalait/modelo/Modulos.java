package com.ayalait.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Modulos implements Serializable{

	private int idmodulo;
    private String modulo;
    private List<Gestiones> gestiones = new ArrayList<>();

    public Modulos(int aInt, String toString) {
        this.idmodulo = aInt;
        this.modulo = toString;
    }

    public int getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(int idmodulo) {
        this.idmodulo = idmodulo;
    }

   

    public Modulos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
        return modulo;
    }

    public List<Gestiones> getGestiones() {
        return gestiones;
    }

    public void setGestiones(List<Gestiones> gestiones) {
        this.gestiones = gestiones;
    }
    
    

}
