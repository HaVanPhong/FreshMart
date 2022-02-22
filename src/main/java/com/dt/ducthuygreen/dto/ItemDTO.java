package com.dt.ducthuygreen.dto;

import com.dt.ducthuygreen.entities.Cart;
import com.dt.ducthuygreen.entities.Product;

public class ItemDTO {
	private String size;
	private Integer quantity;
	private Long price;
	Product product;
	Cart cart;
	
	public ItemDTO() {}
	
	public ItemDTO(String size, Integer quantity, Long price) {
		super();
		this.size = size;
		this.quantity = quantity;
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}	
	
	
}
