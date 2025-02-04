/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayalait.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="contable_libro_diario")
public class ContableLibroDiario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    private String id;
	private String centrocosto;
    private int idtipoie;
    private int moneda;
    private String tipo;
    private int iva;
    private String entradasalida;
    private double saldo;
    private String factura;
    private String fecha;
    private String usuario;
    private String estado;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public ContableLibroDiario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCentrocosto() {
		return centrocosto;
	}
	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public int isIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEntradasalida() {
		return entradasalida;
	}
	public void setEntradasalida(String entradasalida) {
		this.entradasalida = entradasalida;
	}
	public int getIdtipoie() {
		return idtipoie;
	}
	public void setIdtipoie(int idtipoie) {
		this.idtipoie = idtipoie;
	}
	public int getMoneda() {
		return moneda;
	}
	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}
	
    

}
