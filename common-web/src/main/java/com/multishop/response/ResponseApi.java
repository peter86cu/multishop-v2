package com.multishop.response;

import java.util.List;

import com.ayalait.modelo.*;
import com.ayalait.utils.ErrorState;
import com.multishop.modelo.*;


public class ResponseApi {
	
	private int code;
	private boolean status;
	private String resultado;
	private List<Categoria> categorias;
	private List<TipoProducto> tipoProducto;
	private List<MarcaProducto> marcaProducto;
	private List<ModeloProducto> modeloProducto;
    private List<Producto> productos;
	private List<Moneda> moneda;
	private ResultadoDetalleProducto detalle;
	private List<ProductoImagenes> imagenes;
	private List<Categoria> todasCategorias;
	private CarritoDetalle carrito;
	private List<DireccionUsuario> direcciones;
	private ShoppingUsuarios user;
	private ValidarPagoResponse pagoValidado;
	private String cartIDSession;
	private List<OrdenesPagoUsuarios> comprasUsuarios;
	private List<TipoDocumento> tipoDocumento;
	private List<DptoPais> departamentos;
	private ErrorState error;
	
    private int totalItemsProduct;
    private int totalPagesProduct;
	
	public int getTotalItemsProduct() {
		return totalItemsProduct;
	}
	public void setTotalItemsProduct(int totalItemsProduct) {
		this.totalItemsProduct = totalItemsProduct;
	}
	public int getTotalPagesProduct() {
		return totalPagesProduct;
	}
	public void setTotalPagesProduct(int totalPagesProduct) {
		this.totalPagesProduct = totalPagesProduct;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	public ResultadoDetalleProducto getDetalle() {
		return detalle;
	}
	public void setDetalle(ResultadoDetalleProducto detalle) {
		this.detalle = detalle;
	}
	
	public ResponseApi() {
		super();
		//this.setTodasCategorias(null);
		this.setCategorias(null);
		this.setTipoProducto(null);
		this.setDetalle(null);
		this.setDirecciones(null);
		this.setImagenes(null);
		this.setProductos(null);
		this.setUser(null);
		this.setComprasUsuarios(null);
		this.setCarrito(null);
		this.totalItemsProduct=0;
		this.totalPagesProduct=0;
		
		
	}
	
	
	public ShoppingUsuarios getUser() {
		return user;
	}
	public void setUser(ShoppingUsuarios user) {
		this.user = user;
	}
	public ValidarPagoResponse getPagoValidado() {
		return pagoValidado;
	}
	public void setPagoValidado(ValidarPagoResponse pagoValidado) {
		this.pagoValidado = pagoValidado;
	}
	public String getCartIDSession() {
		return cartIDSession;
	}
	public void setCartIDSession(String cartIDSession) {
		this.cartIDSession = cartIDSession;
	}
	
	public List<TipoProducto> getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(List<TipoProducto> tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public List<MarcaProducto> getMarcaProducto() {
		return marcaProducto;
	}
	public void setMarcaProducto(List<MarcaProducto> marcaProducto) {
		this.marcaProducto = marcaProducto;
	}
	public List<ModeloProducto> getModeloProducto() {
		return modeloProducto;
	}
	public void setModeloProducto(List<ModeloProducto> modeloProducto) {
		this.modeloProducto = modeloProducto;
	}
	public List<Moneda> getMoneda() {
		return moneda;
	}
	public void setMoneda(List<Moneda> moneda) {
		this.moneda = moneda;
	}
	public List<ProductoImagenes> getImagenes() {
		return imagenes;
	}
	public void setImagenes(List<ProductoImagenes> imagenes) {
		this.imagenes = imagenes;
	}
	public List<Categoria> getTodasCategorias() {
		return todasCategorias;
	}
	public void setTodasCategorias(List<Categoria> todasCategorias) {
		this.todasCategorias = todasCategorias;
	}
	public List<DireccionUsuario> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<DireccionUsuario> direcciones) {
		this.direcciones = direcciones;
	}
	public List<OrdenesPagoUsuarios> getComprasUsuarios() {
		return comprasUsuarios;
	}
	public void setComprasUsuarios(List<OrdenesPagoUsuarios> comprasUsuarios) {
		this.comprasUsuarios = comprasUsuarios;
	}
	public CarritoDetalle getCarrito() {
		return carrito;
	}
	public void setCarrito(CarritoDetalle carrito) {
		this.carrito = carrito;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ErrorState getError() {
		return error;
	}
	public void setError(ErrorState error) {
		this.error = error;
	}
	public List<TipoDocumento> getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(List<TipoDocumento> tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public List<DptoPais> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<DptoPais> departamentos) {
		this.departamentos = departamentos;
	}
	
	

}
