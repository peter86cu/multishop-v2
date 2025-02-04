package com.ayalait.modelo;

import java.util.List;

public class ResponseApertura {

    private String mensaje;
    private List<String> fechas;

    private List<AperturasTerminal> lstAperturas;

    public List<String> getFechas() {
        return fechas;
    }

    public List<AperturasTerminal> getLstAperturas() {
        return lstAperturas;
    }

    public void setLstAperturas(List<AperturasTerminal> lstAperturas) {
        this.lstAperturas = lstAperturas;
    }

    public void setFechas(List<String> fechas) {
        this.fechas = fechas;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
