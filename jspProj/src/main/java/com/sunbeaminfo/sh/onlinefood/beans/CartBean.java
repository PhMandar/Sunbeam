package com.sunbeaminfo.sh.onlinefood.beans;

import java.util.HashMap;
import java.util.Map;

public class CartBean {
	private String[] qty;
	private Map<Integer, Integer> cart;
	
	public CartBean() {
		this.cart = new HashMap<>();
	}

	public Map<Integer, Integer> getCart() {
		return cart;
	}

	public void setCart(Map<Integer, Integer> cart) {
		this.cart = cart;
	}

	public String[] getQty() {
		return qty;
	}

	public void setQty(String[] qty) {
		this.qty = qty;
	}

	public void addToCart(int idKey, int qtyValue) {
		this.cart.put(idKey, qtyValue);
	}
	
	public int getQuantity(int idKey) {
		return this.cart.getOrDefault(idKey, 0);
	}
}
