package com.multishop.modelo;


import java.util.ArrayList;
import java.util.List;

import com.multishop.response.ResponseApi;

public class Session {

    

    
    private ShoppingUsuariosPago userPago;

	private ShoppingUsuarios user;
    private String token;
    private boolean isLogin;
    public ResponseApi responseResultado;
    public int code;
	public String sessionId;

	public String cardId;

	private List<DireccionUsuario> direcciones;
	private boolean statusApeturaTerminalUser;


	public Session() {
		super();
		this.userPago = null;
		this.user = null;
		this.token = "";
		this.isLogin = false;
		this.responseResultado = new ResponseApi();
		this.sessionId = "";
		this.cardId = "";
		this.direcciones = new ArrayList<DireccionUsuario>();
		this.ip = "";
		this.statusApeturaTerminalUser=false;
	}

	private String ip;

	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isStatusApeturaTerminalUser() {
		return statusApeturaTerminalUser;
	}

	public void setStatusApeturaTerminalUser(boolean statusApeturaTerminalUser) {
		this.statusApeturaTerminalUser = statusApeturaTerminalUser;
	}

	public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public ShoppingUsuariosPago getUserPago() {
		return userPago;
	}

	public void setUserPago(ShoppingUsuariosPago userPago) {
		this.userPago = userPago;
	}

	public ShoppingUsuarios getUser() {
		return user;
	}

	public void setUser(ShoppingUsuarios user) {
		this.user = user;
	}

	public ResponseApi getResponseResultado() {
		return responseResultado;
	}

	public void setResponseResultado(ResponseApi responseResultado) {
		this.responseResultado = responseResultado;
	}


	public List<DireccionUsuario> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<DireccionUsuario> direcciones) {
		this.direcciones = direcciones;
	}
}
