package com.dt.ducthuygreen.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product extends BaseModel implements Serializable {
	@Column(name = "product_name")
    private String productName;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private Long price;

    @Column(name = "description")
    private String description;

    @Column(name = "evaluate")
    private Integer evaluate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "sold")
    private Integer sold;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    Category category = new Category();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Item> items = new ArrayList<>();
    
    public Product() {}
    
	public Product(String productName, String image, Long price, String description, Integer evaluate, Integer quantity,
			Integer sold, Category category, List<Item> items) {
		super();
		this.productName = productName;
		this.image = image;
		this.price = price;
		this.description = description;
		this.evaluate = evaluate;
		this.quantity = quantity;
		this.sold = sold;
		this.category = category;
		this.items = items;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(Integer evaluate) {
		this.evaluate = evaluate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSold() {
		return sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

    
    
}
