package com.dt.ducthuygreen.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dt.ducthuygreen.Utils.ConvertObject;
import com.dt.ducthuygreen.dto.OrderDTO;
import com.dt.ducthuygreen.entities.Cart;
import com.dt.ducthuygreen.entities.Order;
import com.dt.ducthuygreen.entities.User;
import com.dt.ducthuygreen.exception.NotFoundException;
import com.dt.ducthuygreen.repos.OrderRepository;
import com.dt.ducthuygreen.services.ICartService;
import com.dt.ducthuygreen.services.IOrderService;
import com.dt.ducthuygreen.services.UserService;

@Service
public class OrderService implements IOrderService {

	@Autowired private OrderRepository orderRepository;
	@Autowired private UserService userService;
	@Autowired private ICartService cartService;
	
	
	@Override
	public Order getOrderById(Long id) {
		Optional<Order> optional = orderRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}

	@Override
	public Order createNewOrder(Long userId, OrderDTO orderDTO) {
		User user = userService.findById(userId);
		if(user == null) {
			throw new NotFoundException("Can not find userid");
		}
		Order order = ConvertObject.convertOrderDTOToOrder(orderDTO);
		order.setUser_id(userId);
		
		List<Cart> carts = cartService.getAllCartByUserId(userId);
		if(carts.size() == 0) {
			throw new NotFoundException("Not containt cart, can not create order");
		}
		cartService.deleteCartByUserId(userId);
		
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrderByUserId(Long userId) {
		return orderRepository.findAll().stream().filter(item -> item.getUser_id() == userId).collect(Collectors.toList());
	}

	@Override
	public void deleteOrderById(Long orderId) {
		Order order = getOrderById(orderId);
		if(order == null) {
			throw new NotFoundException("Can not find this order");
		}
		orderRepository.delete(order);
	}

}
