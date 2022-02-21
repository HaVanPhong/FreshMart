package com.dt.ducthuygreen.dto;

import javax.persistence.Column;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {
	private String categoryName;

    private String description;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryDTO(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}

	public CategoryDTO() {
		super();
	}
    
    

}
