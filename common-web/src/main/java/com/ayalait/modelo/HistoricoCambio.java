package com.ayalait.modelo;

public class HistoricoCambio {
	private String id;
    private String idmoneda;
    private double valorcompra;
    private double valorventa;
    private String idapertura;

    public HistoricoCambio() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(String idmoneda) {
        this.idmoneda = idmoneda;
    }

    public double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public double getValorventa() {
        return valorventa;
    }

    public void setValorventa(double valorventa) {
        this.valorventa = valorventa;
    }

    public String getIdapertura() {
        return idapertura;
    }

    public void setIdapertura(String idapertura) {
        this.idapertura = idapertura;
    }

    public HistoricoCambio(String id, String idmoneda, double valorcompra, double valorventa, String idapertura) {
        this.id = id;
        this.idmoneda = idmoneda;
        this.valorcompra = valorcompra;
        this.valorventa = valorventa;
        this.idapertura = idapertura;
    }
}

