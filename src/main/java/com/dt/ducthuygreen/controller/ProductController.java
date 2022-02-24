package com.dt.ducthuygreen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dt.ducthuygreen.dto.ProductDTO;
import com.dt.ducthuygreen.services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired private ProductServices productServices;
	
	@GetMapping
	public ResponseEntity<?> getAllProduct(@RequestParam(name = "page", required = false) Integer page) {
		return ResponseEntity.status(200).body(productServices.getAllProduct(page));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
		return ResponseEntity.status(200).body(productServices.getProductById(id));
	}
	
	@PostMapping("/{cateId}")
	public ResponseEntity<?> createNewProduct(
			@PathVariable("cateId") Long cateId,
			@RequestBody ProductDTO productDTO, 
			@RequestParam(name = "image", required = false) MultipartFile image
			) {
		return ResponseEntity.status(201).body(productServices.create(productDTO, cateId, image));
	}
	
	@PostMapping("/{productId}/image")
	public ResponseEntity<?> changeImage(
			@PathVariable("productId") Long productId,
			@RequestParam(name = "image", required = false) MultipartFile image
			) {
		return ResponseEntity.status(201).body(productServices.changeIamge(productId, image));
	}
	
//	@PatchMapping("/{id}")
//	public ResponseEntity<?> editProductById (
//			@PathVariable("id") Long id, 
//			@RequestBody ProductDTO productDTO
//			) {
//		public ResponseEntity.status(200)
//			.body(productServices.editProductById(id, productDTO));
//	}
	
	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable("id") Long id) {
		productServices.deleteProductById(id);
	}
	
}
