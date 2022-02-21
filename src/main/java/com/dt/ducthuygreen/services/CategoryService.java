package com.dt.ducthuygreen.services;

import com.dt.ducthuygreen.dto.CategoryDTO;
import com.dt.ducthuygreen.dto.CategoryUpdateDTO;
import com.dt.ducthuygreen.entities.Category;

public interface CategoryService {
	 	Category findById(Long categoryId);

	    Category findBySlug(String slug);

	    Category create(CategoryDTO categoryDTO);

	    Category update(CategoryUpdateDTO categoryUpdateDTO, Category currentCategory);

	    void deleteById(Long categoryId);

}
