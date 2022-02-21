package com.dt.ducthuygreen.services;

import com.dt.ducthuygreen.dto.ProductDTO;
import com.dt.ducthuygreen.dto.ProductUpdateDTO;
import com.dt.ducthuygreen.entities.Product;

public interface ProductServices {
	Product findById(Long productId);

    Product create(ProductDTO productDTO);

    Product update(ProductUpdateDTO productUpdateDTO, Product currentProduct);

    void update(Product product);

    void deleteById(Long productId);
}
