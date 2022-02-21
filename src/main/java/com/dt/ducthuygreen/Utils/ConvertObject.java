package com.dt.ducthuygreen.Utils;

import com.dt.ducthuygreen.dto.ProductDTO;
import com.dt.ducthuygreen.dto.UserDTO;
import com.dt.ducthuygreen.entities.Product;
import com.dt.ducthuygreen.entities.User;

public class ConvertObject {
	public static User convertUserDTOToUser(User user, UserDTO userDTO) {
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        user.setDescription(userDTO.getDescription());
        user.setFullName(userDTO.getFullName());
        user.setStatus(userDTO.getStatus());
        return user;
    }
	
	public static Product convertProductDTOToProduct(Product product, ProductDTO productDTO) {
		product.setProductName(productDTO.getProductName());
		product.setImage(productDTO.getImage());
		product.setDescription(product.getDescription());
		product.setEvaluate(product.getEvaluate());
		product.setQuantity(productDTO.getQuantity());
		product.setSold(productDTO.getSold());
		
		return product;
	}
}
