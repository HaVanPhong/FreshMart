package com.dt.ducthuygreen.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dt.ducthuygreen.Utils.ConvertObject;
import com.dt.ducthuygreen.dto.ItemDTO;
import com.dt.ducthuygreen.entities.Cart;
import com.dt.ducthuygreen.entities.Item;
import com.dt.ducthuygreen.entities.Product;
import com.dt.ducthuygreen.entities.User;
import com.dt.ducthuygreen.exception.NotFoundException;
import com.dt.ducthuygreen.repos.CartRepository;
import com.dt.ducthuygreen.repos.ItemRepository;
import com.dt.ducthuygreen.services.ICartService;
import com.dt.ducthuygreen.services.IItemService;
import com.dt.ducthuygreen.services.ProductServices;
import com.dt.ducthuygreen.services.UserService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired private ItemRepository itemRepository;
	@Autowired private ProductServices productService;
	@Autowired private ICartService cartService;
	@Autowired private UserService userService;
	
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
	public Item creatNewItem(ItemDTO itemDTO, Long productId, Long cartId, Long userId) {
		Product product = productService.getProductById(productId);
		if(product == null) {
			throw new NotFoundException("ProductId is not containt");
		}
		
		Cart cart = cartService.getById(cartId);
		
		User user = userService.findById(userId);
		if(user == null) {
			throw new NotFoundException("User id is not containt");
		}
		
		//cart k có thì tạo
		if(cart == null) {
			cart = new Cart();
			cart.setUser_id(userId);
			cart.setCreatedBy(user.getFullName());
			cart.setItems(new ArrayList<Item>());
		}
		
		Item item = ConvertObject.convertItemDTOTOItem(itemDTO);
		item.setProduct(product);
		item.setCart(cart);
		
		List<Item> items = cart.getItems();
		items.add(item);
		cart.setItems(items);
		
		Item newItem = itemRepository.save(item);
		cartService.save(cart);
		
		return newItem;
	}

	@Override
	public void deleteItemById(Long id) {
		Item item = getItemById(id);
		if(item != null) {
			itemRepository.delete(item);
		}
	}

}
