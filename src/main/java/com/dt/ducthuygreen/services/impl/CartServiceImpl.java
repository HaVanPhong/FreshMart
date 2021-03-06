package com.dt.ducthuygreen.services.impl;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dt.ducthuygreen.Utils.ConvertObject;
import com.dt.ducthuygreen.dto.CartDTO;
import com.dt.ducthuygreen.entities.Cart;
import com.dt.ducthuygreen.entities.User;
import com.dt.ducthuygreen.exception.NotFoundException;
import com.dt.ducthuygreen.repos.CartRepository;
import com.dt.ducthuygreen.services.ICartService;
import com.dt.ducthuygreen.services.UserService;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired private CartRepository cartRepository;
	@Autowired private UserService userService;
	
	@Override
	public Cart getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Cart> cart = cartRepository.findById(id);
		return cart.isPresent() ? cart.get() : null;
	}

	@Override
	public Cart createNewCart(CartDTO cartDTO, Long userId) {
		User user = userService.findById(userId);
		if(user == null) {
			throw new NotFoundException("UserId is not containt");
		}
		
		cartDTO.setUserId(userId);
		Cart cart = ConvertObject.convertCartDTOTOCart(cartDTO);
		
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getAllCartByUserId(Long userId) {
		List<Cart> cart = cartRepository.findAll();
		
		return cart.stream().filter(item -> item.getUser_id() == userId).collect(Collectors.toList());
	}

	@Override
	public void deleteCartById(Long id) {
		Cart cart = getById(id);
		
		if(cart == null) {
			throw new NotFoundException("Can not find cartId: " + id);
		}
		
		cartRepository.deleteById(cart.getId());
	}

	@Override
	public void deleteCartByUserId(Long userId) {
		// TODO Auto-generated method stub
		List<Cart> carts = cartRepository.findAll();
		carts = carts.stream().filter(item -> item.getUser_id() == userId).collect(Collectors.toList());
		
		if(carts.size() != 0) {
			for(Cart cart : carts) {
				deleteCartById(cart.getId());
			}
		}
	}

	@Override
	public Cart save(Cart cart) {
		return cartRepository.save(cart);
	}

}
