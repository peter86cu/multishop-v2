package com.multishop.modelo;


public class ShoppingUsuarios  {
	

	private String id;
	private String name;
	private String email;
	private String phone;
	private String document;
	private String document_type;
	private String password;
	private int idaddress;
	private int rol;
	private int state;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDocument() {
		return document;
	}


	public void setDocument(String document) {
		this.document = document;
	}


	public String getDocument_type() {
		return document_type;
	}


	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public ShoppingUsuarios() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public int getIdaddress() {
		return idaddress;
	}


	public void setIdaddress(int idaddress) {
		this.idaddress = idaddress;
	}


	public int getRol() {
		return rol;
	}


	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
	
	
}