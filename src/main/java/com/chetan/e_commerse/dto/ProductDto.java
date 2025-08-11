package com.chetan.e_commerse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private Long id;
	private String name;
	private String descrption;
	private Double price;
	private Long catagoryId;
	
}
