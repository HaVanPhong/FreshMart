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

import com.dt.ducthuygreen.dto.ItemDTO;
import com.dt.ducthuygreen.services.IItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	@Autowired private IItemService itemService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllItem() {
		return ResponseEntity.status(200).body(itemService.getAllItem());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllItemById(@PathVariable("id") Long id) {
		return ResponseEntity.status(200).body(itemService.getItemById(id));
	}
	
	@PostMapping("/{productId}/{cartId}/{userId}")
	public ResponseEntity<?> createNewItem(
			@PathVariable("productId") Long productId, 
			@PathVariable("cartId") Long cartId, 
			@PathVariable("userId") Long userId, 
			@RequestBody ItemDTO itemDTO) {
		return ResponseEntity.status(201).body(
				itemService.creatNewItem(itemDTO, productId, cartId, userId)
				);
	}
	
	@DeleteMapping("/{cartId}")
	public ResponseEntity<?> deleteItemById(@PathVariable("id") Long id) {
		itemService.deleteItemById(id);
		return ResponseEntity.status(200).build();
	}
}
