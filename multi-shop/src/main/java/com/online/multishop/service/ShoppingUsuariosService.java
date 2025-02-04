package com.online.multishop.service;

import org.springframework.web.client.RestTemplate;

import com.ayalait.logguerclass.Notification;
import com.ayalait.response.*;
import com.ayalait.utils.Email;
import com.multishop.modelo.*;
import com.multishop.response.ResponseDirecciones;
import com.multishop.response.ResponseUsuarioShopping;
import com.online.multishop.vo.CambioMoneda;

public interface ShoppingUsuariosService {

	ResponseRegistrarUserShop crearUsuario(ShoppingUsuarios usuario);

	ResponseResultado obtenerToken(String mail, String pwd);

	ResponseUsuarioShopping obtenerDatosUsuarioLogin(String token, String mail);

	ResponseUsuarioShopping buscarUsuarioPorId(String token, String id);

	ResponseUsuarioShopping validarUsuario(String mail, String token);

	String salir(RestTemplate template);

	ResponseResultado cambiarPassword(String idUsuario, String pass, String token);

	ResponseResultado guardarDireccionUsuario(DireccionUsuario dir, String token);

	ResponseDirecciones recuperarDreccionUsuarioPorId(String idUsuario, String token);

	ResponseResultado eliminarDreccionUsuarioPorId(int id, String token);
	
	ResponseResultado eliminarCuenta(String id, String token);


	ResponseResultado guardarLog(Notification noti);

	ResponseResultado enviarMailConfirmacion(Email email);

	ResponseResultado confirmarToken(String token);
	
	ResponseUsuarioShopping buscarUserPorToken(String token);
	

}
