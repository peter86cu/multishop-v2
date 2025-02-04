package com.multishop.modelo;


public class ShoppingUsuariosPago  {
	

	private String id;
	private String name;
	private String email;
	private String phone;
	private String document;
	private String document_type;
	private String user_reference;
	private DireccionUsuarioPago address;


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


	


	public ShoppingUsuariosPago() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public String getUser_reference() {
		return user_reference;
	}


	public void setUser_reference(String user_reference) {
		this.user_reference = user_reference;
	}


	public DireccionUsuarioPago getAddress() {
		return address;
	}


	public void setAddress(DireccionUsuarioPago address) {
		this.address = address;
	}
	
	
	
	
}