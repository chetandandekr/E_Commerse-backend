package com.chetan.e_commerse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Schema(
		name= "product ",
		description="from product dto")
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
