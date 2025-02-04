package com.online.multishop.vo;

import com.multishop.modelo.ShoppingUsuariosPago;

public class RequestValidarPago {
	
	private int amount;
	private String currency;
	private String country;
	private String order_id;
	private ShoppingUsuariosPago player;
	private String description;
	private String success_url;
	private String back_url;
	private String notification_url;
	private String expiration_type;
	private String expiration_value;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public ShoppingUsuariosPago getPlayer() {
		return player;
	}
	public void setPlayer(ShoppingUsuariosPago player) {
		this.player = player;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSuccess_url() {
		return success_url;
	}
	public void setSuccess_url(String success_url) {
		this.success_url = success_url;
	}
	public String getBack_url() {
		return back_url;
	}
	public void setBack_url(String back_url) {
		this.back_url = back_url;
	}
	public String getNotification_url() {
		return notification_url;
	}
	public void setNotification_url(String notification_url) {
		this.notification_url = notification_url;
	}
	public String getExpiration_type() {
		return expiration_type;
	}
	public void setExpiration_type(String expiration_type) {
		this.expiration_type = expiration_type;
	}
	public String getExpiration_value() {
		return expiration_value;
	}
	public void setExpiration_value(String expiration_value) {
		this.expiration_value = expiration_value;
	}
	
	
	

}
