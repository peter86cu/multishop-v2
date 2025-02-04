package com.ayalait.modelo;

import java.util.List;

public class CalendarioEmpleado  {
	
    private String idCalendario;

    private String idempleado;
    

    
    private List<HorarioLaboral> horariosLaborales;

	public String getIdCalendario() {
		return idCalendario;
	}

	public void setIdCalendario(String idCalendario) {
		this.idCalendario = idCalendario;
	}

	public String getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(String idempleado) {
		this.idempleado = idempleado;
	}

	public List<HorarioLaboral> getHorariosLaborales() {
		return horariosLaborales;
	}

	public void setHorariosLaborales(List<HorarioLaboral> horariosLaborales) {
		this.horariosLaborales = horariosLaborales;
	}

	
	

	

	

}
