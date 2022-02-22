package com.dt.ducthuygreen.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dt.ducthuygreen.Utils.ConvertObject;
import com.dt.ducthuygreen.dto.ItemDTO;
import com.dt.ducthuygreen.entities.Cart;
import com.dt.ducthuygreen.entities.Item;
import com.dt.ducthuygreen.entities.Product;
import com.dt.ducthuygreen.exception.NotFoundException;
import com.dt.ducthuygreen.repos.ItemRepository;
import com.dt.ducthuygreen.services.ICartService;
import com.dt.ducthuygreen.services.IItemService;
import com.dt.ducthuygreen.services.ProductServices;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired private ItemRepository itemRepository;
	@Autowired private ProductServices productService;
	@Autowired private ICartService cartService;
	
	@Override
	public Item getItemById(Long id) {
		Optional<Item> optional = itemRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public List<Item> getAllItem() {
		return itemRepository.findAll();
	}

	@Override
	public Item creatNewItem(ItemDTO itemDTO, Long productId, Long cartId) {
		Product product = productService.getProductById(productId);
		if(product == null) {
			throw new NotFoundException("ProductId is not containt");
		}
		
		Cart cart = cartService.getById(cartId);
		if(cart == null) {
			throw new NotFoundException("CartId is not containt");
		}
		
		Item item = ConvertObject.convertItemDTOTOItem(itemDTO);
		item.setProduct(product);
		item.setCart(cart);
		return itemRepository.save(item);
	}

	@Override
	public void deleteItemById(Long id) {
		Item item = getItemById(id);
		if(item != null) {
			itemRepository.delete(item);
		}
	}

}
