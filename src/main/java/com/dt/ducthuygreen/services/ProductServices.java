package com.dt.ducthuygreen.services;

import java.util.List;

import com.dt.ducthuygreen.dto.ProductDTO;
import com.dt.ducthuygreen.dto.ProductUpdateDTO;
import com.dt.ducthuygreen.entities.Product;

public interface ProductServices {
    Product create(ProductDTO productDTO);
    List<Product> getAllProduct();
	Product getProductById(Long id);
	Product save(Product product);
	Product editProductById(Long id, ProductDTO productDTO);
	void deleteProductById(Long id);
}
