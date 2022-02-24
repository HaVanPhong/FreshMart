package com.dt.ducthuygreen.services;

import java.util.List;

import com.dt.ducthuygreen.dto.OrderDTO;
import com.dt.ducthuygreen.entities.Order;

public interface IOrderService {
	Order getOrderById(Long id);
	List<Order> getAllOrder();
	Order createNewOrder(Long userId, OrderDTO orderDTO);
	List<Order> getAllOrderByUserId(Long userId);
	void deleteOrderById(Long orderId);
}
