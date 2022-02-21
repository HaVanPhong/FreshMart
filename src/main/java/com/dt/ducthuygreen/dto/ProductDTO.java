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
}
