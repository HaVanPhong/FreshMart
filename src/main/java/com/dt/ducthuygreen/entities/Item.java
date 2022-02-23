package com.dt.ducthuygreen.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Item")
@Getter
@Setter
public class Item extends BaseModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product = new Product();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    Order order = new Order();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    Cart cart = new Cart();

    public Item() {}
    
	public Item(Long id, Boolean deleted, Date createdDate, String createdBy, Date updatedDate, String updatedBy,
			String size, Integer quantity, Long price, Product product, Order order, Cart cart) {
		super(id, deleted, createdDate, createdBy, updatedDate, updatedBy);
		this.size = size;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.order = order;
		this.cart = cart;
	}



	public Item(String size, Integer quantity, Long price) {
		this.size = size;
		this.quantity = quantity;
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
    
    

}
