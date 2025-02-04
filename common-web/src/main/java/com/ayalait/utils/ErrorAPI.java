package com.ayalait.utils;

public class ErrorAPI {
	
	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorAPI(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public ErrorAPI() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
