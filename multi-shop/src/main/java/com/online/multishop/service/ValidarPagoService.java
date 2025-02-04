package com.online.multishop.service;


import com.online.multishop.vo.*;
import com.ayalait.logguerclass.Notification;
import com.ayalait.modelo.AperturasTerminal;
import com.ayalait.modelo.Ventas;
import com.ayalait.modelo.VentasCobro;
import com.ayalait.modelo.VentasDetalle;
import com.ayalait.response.ResponseAperturaTerminal;
import com.ayalait.response.ResponseResultado;
import com.ayalait.response.ResponseValidarEstadoCaja;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.multishop.modelo.OrdenPago;
import com.multishop.response.ResponseOrdenPago;
import com.multishop.response.ResponseValidarPago;




public interface ValidarPagoService {

	ResponseValidarPago validarPagoOrden(RequestValidarPago request)  throws JsonProcessingException;
	int obtenerNumeroOrden();
	ResponseResultado crearOrdenPago(OrdenPago orden);
	ResponseOrdenPago obtenerOrdenPagoPorUsuarios(String idusuario);
	ResponseResultado guardarLog(Notification noti);
	int obtenerConsecutivo();
	ResponseValidarEstadoCaja obtenerAperturaTerminal();
	ResponseResultado abrirTerminal(AperturasTerminal request);
	ResponseAperturaTerminal obtenerAperturaTerminalPorUsuario(); 
	ResponseCambioMoneda obtenerCambioMoneda();
	ResponseResultado guardarVentaCobro(VentasCobro request);
	ResponseVenta addVenta(Ventas request);
	ResponseResultado addDetalleVenta(VentasDetalle request);

    

}
