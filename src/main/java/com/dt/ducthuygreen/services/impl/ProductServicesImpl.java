package com.dt.ducthuygreen.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dt.ducthuygreen.Utils.Constants;
import com.dt.ducthuygreen.Utils.ConvertObject;
import com.dt.ducthuygreen.Utils.UploadFile;
import com.dt.ducthuygreen.dto.ProductDTO;
import com.dt.ducthuygreen.entities.Category;
import com.dt.ducthuygreen.entities.Product;
import com.dt.ducthuygreen.exception.NotFoundException;
import com.dt.ducthuygreen.repos.ProductRepository;
import com.dt.ducthuygreen.services.CategoryService;
import com.dt.ducthuygreen.services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices {

	@Autowired private ProductRepository productRepository;
	@Autowired private CategoryService categoryService;
	private UploadFile uploadFile = new UploadFile();
	
	@Override
	public Product getProductById(Long productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if(!optional.isPresent()) {
			throw new NotFoundException("Can not find product by id: " + productId);
		}
		return optional.get();
	}

	@Override
	public List<Product> getAllProduct(Integer page) {
		if(page != null) {
			return productRepository.findAll(PageRequest.of(page.intValue(), Constants.PAGE_SIZE)).getContent();
		}
		return productRepository.findAll();
	}
	
	@Override
	public Product create(ProductDTO productDTO, Long categoryId, MultipartFile file) {
		Product product = new Product();
		
		Category category = categoryService.findById(categoryId);
		
		if(category == null) {
			throw new NotFoundException("Can not find category id: " + categoryId);
		}
		
		product.setCategory(category);
		if(file != null) {
			product.setImage(uploadFile.getUrlFromFile(file));
		}
		
		return productRepository.save(ConvertObject.convertProductDTOToProduct(product, productDTO));
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

	@Override
	public Product changeIamge(Long id, MultipartFile file) {
		if(file == null) {
			return null;
		}
		
		Product product = getProductById(id);
		if(product == null) {
			throw new NotFoundException("Can not find this product");
		}
		
		if(product.getImage() != null) {
			uploadFile.removeImageFromUrl(product.getImage());
		}
		
		product.setImage(uploadFile.getUrlFromFile(file));
		
		return productRepository.save(product);
	}
}
