package com.ayalait.modelo;



public class Moneda {

	 private int id;
	    private String moneda;
	    private String simbolo;
	    private double valorventa;
	    private double valorcompra;
	    private int estado;
	    private int defecto;
	    private int idCambioVenta;	    
		private String codigo;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getMoneda() {
	        return moneda;
	    }

	    public void setMoneda(String moneda) {
	        this.moneda = moneda;
	    }

	    public String getSimbolo() {
	        return simbolo;
	    }

	    public void setSimbolo(String simbolo) {
	        this.simbolo = simbolo;
	    }

	   
	    
	     @Override
	    public String toString() {
	        return moneda;
	    }

	    public Moneda() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Moneda(int id, String moneda, String simbolo) {
	        this.id = id;
	        this.moneda = moneda;
	        this.simbolo = simbolo;
	    }

	    public double getValorventa() {
	        return valorventa;
	    }

	    public void setValorventa(double valorventa) {
	        this.valorventa = valorventa;
	    }

	    public double getValorcompra() {
	        return valorcompra;
	    }

	    public void setValorcompra(double valorcompra) {
	        this.valorcompra = valorcompra;
	    }

		public int getEstado() {
			return estado;
		}

		public void setEstado(int estado) {
			this.estado = estado;
		}

		public int getDefecto() {
			return defecto;
		}

		public void setDefecto(int defecto) {
			this.defecto = defecto;
		}

		public int getIdCambioVenta() {
			return idCambioVenta;
		}

		public void setIdCambioVenta(int idCambioVenta) {
			this.idCambioVenta = idCambioVenta;
		}

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		
	    
}
