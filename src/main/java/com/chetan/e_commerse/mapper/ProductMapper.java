package com.chetan.e_commerse.mapper;

import com.chetan.e_commerse.dto.ProductDto;
import com.chetan.e_commerse.entity.Catagory;
import com.chetan.e_commerse.entity.Product;

public class ProductMapper {

	public static ProductDto toProductDto(Product product) {
		return new ProductDto(
				product.getId(),
				product.getName(),
				product.getDescriptuion(),
				product.getPrice(),
				product.getCatagory().getId());
	}
	public static Product toEntityProduct(ProductDto productDto, Catagory catagory) {
		Product product =new Product();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setCatagory(catagory);
		product.setDescriptuion(productDto.getDescrption());
		return product;
		
	}
}
