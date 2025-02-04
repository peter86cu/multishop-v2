package com.ayalait.modelo;


import java.util.List;

public class PuntoVentaDatos {
        private boolean status;
        private int code;

        private List<ItemVentaActual> itemsVentaActual;
    private double subTotal;
    private String IVA;

    private String simboloMoneda;
    private double ivaCalculado;
    private double ajusteRedondeo;
    private double totalAPagar;

    private int id_cliente;


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getIVA() {
        return IVA;
    }

    public void setIVA(String IVA) {
        this.IVA = IVA;
    }

    public double getAjusteRedondeo() {
        return ajusteRedondeo;
    }

    public void setAjusteRedondeo(double ajusteRedondeo) {
        this.ajusteRedondeo = ajusteRedondeo;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public List<ItemVentaActual> getItemsVentaActual() {
        return itemsVentaActual;
    }

    public void setItemsVentaActual(List<ItemVentaActual> itemsVentaActual) {
        this.itemsVentaActual = itemsVentaActual;
    }

    public double getIvaCalculado() {
        return ivaCalculado;
    }

    public void setIvaCalculado(double ivaCalculado) {
        this.ivaCalculado = ivaCalculado;
    }

    public String getSimboloMoneda() {
        return simboloMoneda;
    }

    public void setSimboloMoneda(String simboloMoneda) {
        this.simboloMoneda = simboloMoneda;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
