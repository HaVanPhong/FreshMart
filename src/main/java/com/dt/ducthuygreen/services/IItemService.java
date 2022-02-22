package com.dt.ducthuygreen.services;

import java.util.List;

import com.dt.ducthuygreen.dto.ItemDTO;
import com.dt.ducthuygreen.entities.Item;

public interface IItemService {
	Item getItemById(Long id);
	List<Item> getAllItem();
	Item creatNewItem(ItemDTO itemDTO, Long productId, Long cartId);
	
	void deleteItemById(Long id);
}
