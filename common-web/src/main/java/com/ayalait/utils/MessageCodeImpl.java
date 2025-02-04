package com.ayalait.utils;

import java.util.Map;

public class MessageCodeImpl {

    public static String getMensajeHttp(String code) {
        String resultMenssage="No se ha definido mensaje para el codigo: "+code;
        Map<String,String> message= Messages.listMessagesHTTP();
        if(message.containsKey(code)){
            return message.get(code);
        }
        return resultMenssage;
    }
    
    public static String getMensajeService(String code) {
        String resultMenssage="No se ha definido mensaje para el codigo: "+code;
        Map<String,String> message= Messages.listMessagesService();
        if(message.containsKey(code)){
            return message.get(code);
        }
        return resultMenssage;
    }
    
    public static String getMensajeServiceUsuarios(String code) {
        String resultMenssage="No se ha definido mensaje para el codigo: "+code;
        Map<String,String> message= Messages.listMessagesUsuarios();
        if(message.containsKey(code)){
            return message.get(code);
        }
        return resultMenssage;
    }
    
    public static String getMensajeAPIPago(String code) {
        String resultMenssage="No se ha definido mensaje para el codigo: "+code;
        Map<String,String> message= Messages.listMessagesApiPago();
        if(message.containsKey(code)){
            return message.get(code);
        }
        return resultMenssage;
    }
    
    public static String getMensajeServiceEmpleados(String code) {
        String resultMenssage="No se ha definido mensaje para el codigo: "+code;
        Map<String,String> message= Messages.listMessagesEmpleado();
        if(message.containsKey(code)){
            return message.get(code);
        }
        return resultMenssage;
    }
    
    public static String getMensajeServiceTerminal(String code) {
        String resultMenssage="No se ha definido mensaje para el codigo: "+code;
        Map<String,String> message= Messages.listMessagesTerminal();
        if(message.containsKey(code)){
            return message.get(code);
        }
        return resultMenssage;
    }
    
    public static String getMensajeServiceCompras(String code) {
        String resultMenssage="No se ha definido mensaje para el codigo: "+code;
        Map<String,String> message= Messages.listMessagesCompras();
        if(message.containsKey(code)){
            return message.get(code);
        }
        return resultMenssage;
    }
    
    public static String getMensajeServiceMarcasEmpleados(String code) {
        String resultMenssage="No se ha definido mensaje para el codigo: "+code;
        Map<String,String> message= Messages.listMessagesMarcasEmpleado();
        if(message.containsKey(code)){
            return message.get(code);
        }
        return resultMenssage;
    }

}
