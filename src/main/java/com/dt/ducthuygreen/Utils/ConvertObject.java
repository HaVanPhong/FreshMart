package com.dt.ducthuygreen.Utils;

import com.dt.ducthuygreen.dto.CartDTO;
import com.dt.ducthuygreen.dto.ItemDTO;
import com.dt.ducthuygreen.dto.OrderDTO;
import com.dt.ducthuygreen.dto.ProductDTO;
import com.dt.ducthuygreen.dto.UserDTO;
import com.dt.ducthuygreen.entities.Cart;
import com.dt.ducthuygreen.entities.Item;
import com.dt.ducthuygreen.entities.Order;
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
	
	public static Cart convertCartDTOTOCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setUser_id(cartDTO.getUserId());
		cart.setItems(cartDTO.getItems());
		return cart;
	}
	
	public static Item convertItemDTOTOItem(ItemDTO itemDTO) {
		return new Item(itemDTO.getSize(), itemDTO.getQuantity(), itemDTO.getPrice());
	}
	
	public static Order convertOrderDTOToOrder(OrderDTO orderDTO) {
		Order order = new Order();
		order.setEmail(orderDTO.getEmail());
		order.setFirstName(orderDTO.getFirstName());
		order.setLastName(orderDTO.getLastName());
		order.setAddress(orderDTO.getAddress());
		order.setPhone(orderDTO.getPhone());
		order.setPostcode(orderDTO.getPostcode());
		order.setTotalPrice(orderDTO.getTotalPrice());
		order.setTotalQuantity(orderDTO.getTotalQuantity());
		order.setStatus(true);
		
		return order;
	}
}
