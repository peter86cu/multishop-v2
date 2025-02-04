package com.multishop.response;

import java.util.List;

import com.multishop.modelo.ShoppingCart;
import com.multishop.modelo.ShoppingCartDetailTemp;

 
public class CarritoDetalle {

	private ShoppingCart cart;	
	private List<ShoppingCartDetailTemp> detalle;

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public CarritoDetalle() {
		super();
		// TODO Auto-generated constructor stub
		// this.detalle= null;
		// this.cart= null;
	}

	public List<ShoppingCartDetailTemp> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<ShoppingCartDetailTemp> detalle) {
		this.detalle = detalle;
	}

	
	
	

}
