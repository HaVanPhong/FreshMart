package com.dt.ducthuygreen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
	private String productName;
	
    private String image;

    private Long price;

    private String description;

    private Integer evaluate;

    private Integer quantity;

    private Integer sold;

    public ProductDTO() {}
    
	public ProductDTO(String productName, String image, Long price, String description, Integer evaluate,
			Integer quantity, Integer sold) {
		super();
		this.productName = productName;
		this.image = image;
		this.price = price;
		this.description = description;
		this.evaluate = evaluate;
		this.quantity = quantity;
		this.sold = sold;
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
    
    
}
