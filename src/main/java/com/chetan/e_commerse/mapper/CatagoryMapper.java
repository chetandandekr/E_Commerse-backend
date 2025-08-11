package com.chetan.e_commerse.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.chetan.e_commerse.dto.CatagoryDto;
import com.chetan.e_commerse.entity.Catagory;

public class CatagoryMapper {
 
	public static CatagoryDto toCatagoryDto(Catagory catagory) {
		if(catagory==null) {
			return null;
		}
		 
		CatagoryDto catagorydto=new CatagoryDto();
		catagorydto.setId(catagory.getId());
		catagorydto.setName(catagory.getName());
		catagorydto.setProducts(catagory.getProducts().stream().map(ProductMapper::toProductDto).toList());
		return catagorydto;
	}
	public static Catagory toCtagoryEntity(CatagoryDto catagoryDto) {
		Catagory catagory=new Catagory();
		catagory.setName(catagoryDto.getName());
	return	catagory;
	}
}
