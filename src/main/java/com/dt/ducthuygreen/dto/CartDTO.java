package com.dt.ducthuygreen.dto;

import java.util.ArrayList;
import java.util.List;

import com.dt.ducthuygreen.entities.Item;

public class CartDTO {
	private Long userId;
	private List<Item> items = new ArrayList<>();
	
	public CartDTO() {};
	
	public CartDTO(Long userId, List<Item> items) {
		super();
		this.userId = userId;
		this.items = items;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
