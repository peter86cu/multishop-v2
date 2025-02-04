package com.online.multishop.vo;


import java.util.ArrayList;
import java.util.List;

import com.multishop.modelo.*;

 


public class RequestAddCart {
	
	private ShoppingCart cart;
	private List<ShoppingCartDetail> detalle;
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public List<ShoppingCartDetail> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<ShoppingCartDetail> detalle) {
		this.detalle = detalle;
	}
	public RequestAddCart() {
		super();
		this.cart = new ShoppingCart();
		this.detalle = new ArrayList<ShoppingCartDetail>();
	}
	 
	
	
	

}
