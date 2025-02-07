package com.online.multishop.service;



 
 import com.ayalait.logguerclass.Notification;
import com.multishop.response.*;
import com.online.multishop.vo.RequestAddCart;
import com.online.multishop.vo.ResponsePreguntaRespuesta;
import com.ayalait.response.*;
 


public interface ParametrosService {

	ResponseTipoProducto listadoTipoProducto();
	
    ResponseCategorias listarCategorias();
    
    ResponseListaMarcasProducto listadoMarcasProducto();
    
    ResponseListaModeloProducto listadoModelosProducto();    
    
    ResponseListaProductos consultarListaProductos() ;
    
    ResponseMonedas listarMonedas();
    
    ResponseListaTipoDoc listadoTipoDocumento();
    
    ResponseImagenesProducto imagenesProducto(String id);
    
    ResponseDetalleProducto detalleProducto(String id);
    
    ResponseResultado guardarCarrito(RequestAddCart request);
    
    ResponseCart obtenerCarrito(String idCart,String idUsuario);
    
    ResponseCartUsuario obtenerCarritoPorUsuario(String idUsuario);
    
    ResponseHistoryEstadoCart obtenerEstadoCarrito(int id);
    
    ResponseResultado guardarLog(Notification noti);
    
    ResponseListaDpto listadoDptoPais();
    
    ResponseResultado deleteCarById(String id);
    
    ResponsePreguntaRespuesta obtenerPreguntasRespuestas(String idProducto);
    
    ResponseResultado enviarPregunta(String idProducto, String idUsuarioPregunta, String pregunta);
    
    ResponseResultado enviarRespuesta(int idPregunta, String idUsuarioRespuesta, String respuesta);
    
    ResponseListaProductos cargarProductosRelacionados(int idTipoProducto, int idCategoriaProducto);
    
    ResponseListaFormasCobro listaFormasCobros();


}
