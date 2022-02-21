package com.dt.ducthuygreen.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dt.ducthuygreen.Utils.ConvertObject;
import com.dt.ducthuygreen.dto.ProductDTO;
import com.dt.ducthuygreen.entities.Product;
import com.dt.ducthuygreen.exception.NotFoundException;
import com.dt.ducthuygreen.repos.ProductRepository;
import com.dt.ducthuygreen.services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices {

	@Autowired private ProductRepository productRepository;
	
	@Override
	public Product getProductById(Long productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if(!optional.isPresent()) {
			throw new NotFoundException("Can not find product by id: " + productId);
		}
		return optional.get();
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	@Override
	public Product create(ProductDTO productDTO) {
		return productRepository.save(ConvertObject.convertProductDTOToProduct(new Product(), productDTO));
	}

	@Override
	public Product editProductById(Long id, ProductDTO productDTO) {
		Product product = getProductById(id);
		
		return productRepository.save(ConvertObject.convertProductDTOToProduct(product, productDTO));
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public void deleteProductById(Long id) {
		Product product = getProductById(id);
		
		productRepository.delete(product);
	}
}
