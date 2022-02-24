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
		if(userDTO.getUsername()!=null)
        user.setUsername(userDTO.getUsername());
		
		if(userDTO.getEmail()!=null)
        user.setEmail(userDTO.getEmail());
		
		if(userDTO.getFullName()!=null)
        user.setFullName(userDTO.getFullName());
		
		if(userDTO.getDescription()!=null)
        user.setDescription(userDTO.getDescription());
		
		if(userDTO.getFullName()!=null)
        user.setFullName(userDTO.getFullName());
		
		if(userDTO.getStatus()!=null)
        user.setStatus(userDTO.getStatus());
        return user;
    }
	
	public static Product convertProductDTOToProduct(Product product, ProductDTO productDTO) {
		if(productDTO.getCreatedDate()!=null)
		product.setCreatedDate(productDTO.getCreatedDate());
		
		if(productDTO.getCreatedBy()!=null)
		product.setCreatedBy(productDTO.getCreatedBy());
		
		if(productDTO.getDeleted()!=null)
		product.setDeleted(productDTO.getDeleted());
		
		if(productDTO.getUpdatedBy()!=null)
		product.setUpdatedBy(productDTO.getUpdatedBy());
		
		if(productDTO.getUpdatedDate()!=null)
		product.setUpdatedDate(productDTO.getUpdatedDate());
		
		if(productDTO.getProductName()!=null)
		product.setProductName(productDTO.getProductName());
		
		if(productDTO.getImage()!=null)
		product.setImage(productDTO.getImage());
		
		if(productDTO.getPrice()!=null)
		product.setPrice(productDTO.getPrice());
		
		if(productDTO.getDescription()!=null)
		product.setDescription(productDTO.getDescription());
		
		if(productDTO.getEvaluate()!=null)
		product.setEvaluate(productDTO.getEvaluate());
		
		if(productDTO.getQuantity()!=null)
		product.setQuantity(productDTO.getQuantity());
		
		if(productDTO.getSold()!=null)
		product.setSold(productDTO.getSold());
		
		return product;
	}
	
	public static Cart convertCartDTOTOCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		if (cartDTO.getUserId()!=null)
		cart.setUser_id(cartDTO.getUserId());
		
		if (cartDTO.getItems()!=null)
		cart.setItems(cartDTO.getItems());
		return cart;
	}
	
	public static Item convertItemDTOTOItem(ItemDTO itemDTO) {
		return new Item(itemDTO.getSize(), itemDTO.getQuantity(), itemDTO.getPrice());
	}
	
	public static Order convertOrderDTOToOrder(OrderDTO orderDTO) {
		Order order = new Order();
		if (orderDTO.getEmail()!=null)
		order.setEmail(orderDTO.getEmail());
		
		if (orderDTO.getFirstName()!=null)
		order.setFirstName(orderDTO.getFirstName());
		
		if (orderDTO.getLastName()!=null)
		order.setLastName(orderDTO.getLastName());
		
		if (orderDTO.getAddress()!=null)
		order.setAddress(orderDTO.getAddress());
		
		if (orderDTO.getPhone()!=null)
		order.setPhone(orderDTO.getPhone());
		
		if (orderDTO.getPostcode()!=null)
		order.setPostcode(orderDTO.getPostcode());
		
		if (orderDTO.getTotalPrice()!=null)
		order.setTotalPrice(orderDTO.getTotalPrice());
		
		if (orderDTO.getTotalQuantity()!=null)
		order.setTotalQuantity(orderDTO.getTotalQuantity());
		
		order.setStatus(true);
		
		return order;
	}
}