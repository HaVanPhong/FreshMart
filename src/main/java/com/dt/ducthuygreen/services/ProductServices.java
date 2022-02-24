package com.dt.ducthuygreen.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dt.ducthuygreen.dto.ProductDTO;
import com.dt.ducthuygreen.entities.Product;

public interface ProductServices {
    Product create(ProductDTO productDTO, Long categoryId, MultipartFile file);
    List<Product> getAllProduct(Integer page);
	Product getProductById(Long id);
	Product changeIamge(Long id, MultipartFile file);
	Product save(Product product);
	Product editProductById(Long id, ProductDTO productDTO);
	void deleteProductById(Long id);
}
