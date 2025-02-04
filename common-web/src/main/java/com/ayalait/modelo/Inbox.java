package com.ayalait.modelo;




public class Inbox  {

    private String id;
    private String remite;
    private String para;
    private String fecha;
    private String asunto;
    private String cuerpo;
    private String estado;
    private String usuario;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
	public String getRemite() {
		return remite;
	}

	public void setRemite(String remite) {
		this.remite = remite;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Inbox() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	
	
}
