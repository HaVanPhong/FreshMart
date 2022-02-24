package com.dt.ducthuygreen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dt.ducthuygreen.dto.OrderDTO;
import com.dt.ducthuygreen.services.IOrderService;

@RestController
@RequestMapping("/api/order-items")
public class OrderController {
	@Autowired private IOrderService orderService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllCartByUserId(@PathVariable("userId") Long userId) {
		return ResponseEntity.status(200).body(orderService.getAllOrderByUserId(userId));
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAllCart() {
		return ResponseEntity.status(200).body(orderService.getAllOrder());
	}
	
	@PostMapping("/{userId}")
	public ResponseEntity<?> createNewOrder(@RequestBody OrderDTO orderDTO, @PathVariable("userId") Long userId) {
		return ResponseEntity.status(201).body(orderService.createNewOrder(userId, orderDTO));
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?> deleteOrderById(@PathVariable("orderId") Long orderId) {
		orderService.deleteOrderById(orderId);
		return ResponseEntity.status(200).build();
	}
}
