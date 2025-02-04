package com.ayalait.modelo;

import java.util.List;

import com.ayalait.utils.DiaAbierto;

public class Session {

    

    
    private User user;
    private String token;
    private String rolLogin;
    private String moduloAcceso;
    private boolean tokenValido;
    private Modulos[] listaModulos;
    private int id_empresa;
    private int idModuloLogin;
    private Acceso accesos;
    private String idAperturaDia;
    private List<DiaAbierto> oepnDay;

    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Acceso getAccesos() {
        return accesos;
    }

    public void setAccesos(Acceso accesos) {
        this.accesos = accesos;
    }

    public String getRolLogin() {
        return rolLogin;
    }

    public void setRolLogin(String rolLogin) {
        this.rolLogin = rolLogin;
    }

    public int getIdModuloLogin() {
        return idModuloLogin;
    }

    public void setIdModuloLogin(int idModuloLogin) {
        this.idModuloLogin = idModuloLogin;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public boolean isTokenValido() {
        return tokenValido;
    }

    public void setTokenValido(boolean tokenValido) {
        this.tokenValido = tokenValido;
    }

    public String getModuloAcceso() {
        return moduloAcceso;
    }

    public void setModuloAcceso(String moduloAcceso) {
        this.moduloAcceso = moduloAcceso;
    }

    public Modulos[] getListaModulos() {
        return listaModulos;
    }

    public void setListaModulos(Modulos[] listaModulos) {
        this.listaModulos = listaModulos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public String getIdAperturaDia() {
		return idAperturaDia;
	}

	public void setIdAperturaDia(String idAperturaDia) {
		this.idAperturaDia = idAperturaDia;
	}

	public List<DiaAbierto> getOepnDay() {
		return oepnDay;
	}

	public void setOepnDay(List<DiaAbierto> oepnDay) {
		this.oepnDay = oepnDay;
	}

    

   

}
