package com.ayalait.modelo;


public class EmpleadoCargo {

	
	private int id;
	private int iddepartamento;
	private String idempleado;
	private int idcargo;
	private int idhorario;
	private float salarionominal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	

	public String getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(String idempleado) {
		this.idempleado = idempleado;
	}

	public int getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
	}

	public int getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}

	public EmpleadoCargo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float getSalarionominal() {
		return salarionominal;
	}

	public void setSalarionominal(float salarionominal) {
		this.salarionominal = salarionominal;
	}

}
