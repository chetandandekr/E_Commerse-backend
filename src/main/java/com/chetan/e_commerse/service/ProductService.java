package com.chetan.e_commerse.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetan.e_commerse.dto.ProductDto;
import com.chetan.e_commerse.entity.Catagory;
import com.chetan.e_commerse.entity.Product;
import com.chetan.e_commerse.exception.CatagoryNotFoundException;
import com.chetan.e_commerse.mapper.ProductMapper;
import com.chetan.e_commerse.reposietry.CatagoryRepositery;
import com.chetan.e_commerse.reposietry.ProductRepositery;

@Service
public class ProductService {

	@Autowired
	private ProductRepositery productRepositery;
	@Autowired
	private CatagoryRepositery catagoryRepositery;
	
	public ProductDto createProduct(ProductDto productDto) {
		Catagory catagory = catagoryRepositery.findById(productDto.getCatagoryId())
				.orElseThrow(() -> new CatagoryNotFoundException("catagory not found"));
		Product product = ProductMapper.toEntityProduct(productDto, catagory);

		product = productRepositery.save(product);

		return ProductMapper.toProductDto(product);
	}
	
	public List<ProductDto> getAllProduct()
	{
		return productRepositery.findAll().stream().map(ProductMapper::toProductDto).toList();
	}

	public ProductDto getProductByid(Long id) {
		
		Product product = productRepositery.findById(id).orElseThrow(()-> new RuntimeException("product not found !"));		
	return	ProductMapper.toProductDto(product);
	}
	
	public ProductDto updateProduct(ProductDto productDto) {
		Catagory catagory = catagoryRepositery.findById(productDto.getCatagoryId()).orElseThrow(()->new RuntimeException("catagory not found !"));
		Product product = productRepositery.findById(productDto.getId()).orElseThrow(()-> new RuntimeException("product not found !"));	
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setDescriptuion(productDto.getDescrption());
		product.setCatagory(catagory);
	
	    product=productRepositery.save(product);
	    return ProductMapper.toProductDto(product);
		
	}
	
	
}
