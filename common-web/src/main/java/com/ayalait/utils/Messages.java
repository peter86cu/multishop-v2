package com.ayalait.utils;

import java.util.HashMap;
import java.util.Map;

public class Messages {
	
	/********************MENSAJE PRODUCTO INICIO******************************/
	//MENSAJE SATISFACTORIOS
    public static final String CODE_SERVICE_PRODUCT_ADD_OK="0001";
    public static final String CODE_SERVICE_PRODUCT_DELETE="0002";
    public static final String CODE_SERVICE_PRODUCT_UPDATE="0003";


    //MENSAJES NO OK
    public static final String CODE_SERVICE_PRODUCT_SEARCH_NOOK="0004";
    public static final String CODE_SERVICE_PRODUCT_NOOK="0005";
    
    //MENSAJES HTP
    public static final String err_connection_timed_out="1000";


	/********************MENSAJE PRODUCTO FIN******************************/


    public static Map<String, String> listMessagesHTTP() {
        Map<String,String> message= new HashMap<>();
        message.put("200","OK");
        message.put("400","El usuario no existe.");
        message.put("406","Credenciales incorrectas.");
        message.put("1000","Se acabó el tiempo de conexión");
        message.put("1001","Token no enviado en el request.");
        return message;
    }
    
    public static Map<String, String> listMessagesTerminal() {
        Map<String,String> message= new HashMap<>();
        message.put("0001","El producto fue creado correptamente.");
        message.put("406","El día ya esta abierto. ");
        message.put("401","El día no esta abierto.");

        message.put("0004","No existe el producto.");
        message.put("0005","Ocurrio un error, intente de nuevo o pongase en contacto con un Administrador.");

        return message;
    }
    
    public static Map<String, String> listMessagesUsuarios() {
        Map<String,String> message= new HashMap<>();
        message.put("7000","Expiró la confirmación del registro del usuario.");
        message.put("70001", "Su cuenta se ha creado correctamente. Para acceder al [portal del cliente], haga clic en el siguiente enlace.");
        message.put("70002","Ya existe un registro con la dirección de correo ingresada.");
        message.put("70003","Ya existe un registro con el documento ingresado.");
        message.put("70004","El usuario no existe.");
        message.put("406","Credenciales incorreptas.");
        message.put("2","El usuario esta INACTIVO.");
        message.put("3","El usuario esta ELIMINADO.");
        message.put("4","El usuario esta BLOQUEADO.");
        message.put("5","El usuario esta NO EXISTE.");
        message.put("6","El usuario esta POR CONFIRMAR. Habilitelo a traves del mail enviado.");






        return message;
    }
    
    public static Map<String, String> listMessagesEmpleado() {
        Map<String,String> message= new HashMap<>();
        message.put("0001","El producto fue creado correptamente.");
        message.put("400","No existe calendario generado para el empleado ");
        message.put("401","El día no esta abierto.");

        message.put("0004","No existe el producto.");
        message.put("0005","Ocurrio un error, intente de nuevo o pongase en contacto con un Administrador.");

        return message;
    }
    
    public static Map<String, String> listMessagesService() {
        Map<String,String> message= new HashMap<>();
        message.put("0001","El producto fue creado correctamente.");
        message.put("0002","El producto ha sido eliminado correptamente.");
        message.put("0003","El producto se actualizó correptamente.");

        message.put("0004","No existe el producto.");
        message.put("0005","Ocurrio un error, intente de nuevo o pongase en contacto con un Administrador.");

        return message;
    }
    
    
    public static Map<String, String> listMessagesCompras() {
        Map<String,String> message= new HashMap<>();
        message.put("10001","Usted no ha realizado ninguna compra aún.");
        
        return message;
    }
    
    /********************MENSAJE API DE PAGO**************************/
    public static Map<String, String> listMessagesApiPago() {
        Map<String,String> message= new HashMap<>();
        message.put("3001","Credenciales no válidas.");
        message.put("3003","El comerciante no tiene autorización para utilizar esta API.");
        message.put("4000","Pago no encontrado.");

        message.put("5000","Solicitud no válida.");
        message.put("5001","Parametro invalido.");
        message.put("5003","País no admitido.");
        message.put("5007","Cantidad excedida.");
        message.put("5009","La identificación del pedido está duplicada.");
        message.put("5010","Método de pago no disponible.");
        message.put("5016","Cantidad demasiado baja.");
        message.put("6000","Demasiadas solicitudes a la API.");
        message.put("7000","No se pudo procesar la solicitud.");
        message.put("7001","Pide tiempo fuera.");

        return message;
    }
    
    /***************************Marcas empleados**********************************/
    public static Map<String, String> listMessagesMarcasEmpleado() {
        Map<String,String> message= new HashMap<>();
        message.put("3001","No se encontraron registros para el filtro de busqueda.");
        message.put("3002","Error procesando la marca. Estado INCONSISTENTE.");
        message.put("3003", "No se registraron marcas para la fecha solicitada.");
        
        return message;
    }
}
