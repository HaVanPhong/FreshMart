package com.dt.ducthuygreen.dto;

import com.dt.ducthuygreen.entities.BaseModel;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryUpdateDTO extends BaseModel {
	private String categoryName;

    private String description;
	

}
