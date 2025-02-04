package com.ayalait.modelo;

import java.text.DecimalFormat;


public class Producto {

	private String id;

	private String codigo;
	private String nombre;
	private int categoria;
	private int um;
	private double precioventa;
	private int cantidadminima;
	private String foto;
	private int idestado;
	private int idiva;
	private int tipoproducto;
	private boolean inventariable;
	private boolean disponible;
	private String imagen;
	private int marca;
	private int modelo;
	private int moneda;
	private double preciooriginal;

	private int descuento;

	private int cuotaspago;

	private int cantidadResenas;
	private double promedioEstrellas;
	private int descuentoPorcentaje;

	private double porcentajeMasVendido;
	private int posicionMasVendido;

	public String getPrecioventaFormateado() {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(precioventa);
	}

	public String getPreciooriginalFormateado() {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(preciooriginal);
	}

	public String getCuotasFormateadas() {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(precioventa / cuotaspago);
	}

	public int getCantidadResenas() {
		return cantidadResenas;
	}

	public void setCantidadResenas(int cantidadResenas) {
		this.cantidadResenas = cantidadResenas;
	}

	public double getPromedioEstrellas() {
		return promedioEstrellas;
	}

	public void setPromedioEstrellas(double promedioEstrellas) {
		this.promedioEstrellas = promedioEstrellas;
	}

	public int getDescuentoPorcentaje() {
		return descuentoPorcentaje;
	}

	public void setDescuentoPorcentaje(int descuentoPorcentaje) {
		this.descuentoPorcentaje = descuentoPorcentaje;
	}

	public double getPreciooriginal() {
		return preciooriginal;
	}

	public void setPreciooriginal(double preciooriginal) {
		this.preciooriginal = preciooriginal;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public int getCuotaspago() {
		return cuotaspago;
	}

	public void setCuotaspago(int cuotaspago) {
		this.cuotaspago = cuotaspago;
	}

	public Producto() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getUm() {
		return um;
	}

	public void setUm(int um) {
		this.um = um;
	}

	public double getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(double precioventa) {
		this.precioventa = precioventa;
	}

	public int getCantidadminima() {
		return cantidadminima;
	}

	public void setCantidadminima(int cantidadminima) {
		this.cantidadminima = cantidadminima;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public int getIdiva() {
		return idiva;
	}

	public void setIdiva(int idiva) {
		this.idiva = idiva;
	}

	public int getTipoproducto() {
		return tipoproducto;
	}

	public void setTipoproducto(int tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	public boolean isInventariable() {
		return inventariable;
	}

	public void setInventariable(boolean inventariable) {
		this.inventariable = inventariable;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getMarca() {
		return marca;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public int getMoneda() {
		return moneda;
	}

	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}

	public double getPorcentajeMasVendido() {
		return porcentajeMasVendido;
	}

	public void setPorcentajeMasVendido(double porcentajeMasVendido) {
		this.porcentajeMasVendido = porcentajeMasVendido;
	}

	public int getPosicionMasVendido() {
		return posicionMasVendido;
	}

	public void setPosicionMasVendido(int posicionMasVendido) {
		this.posicionMasVendido = posicionMasVendido;
	}

}
