package com.chetan.e_commerse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.e_commerse.dto.ProductDto;
import com.chetan.e_commerse.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
		name="Product REST API Service",
		description="CREATE,READ,DELETE AND UPDATE REST API ")
@RestController
@RequestMapping("/api/product")
public class ProductController {
 
	@Autowired
	private ProductService  productSrvice;
	
	@Operation(
			summary="Creating new product",
			description ="Create New product and return exciting product")
	@PostMapping("/create")
	public ResponseEntity<ProductDto>  createProduct(@RequestBody ProductDto productDto) {
		return new ResponseEntity<>( productSrvice.createProduct(productDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<ProductDto>> getAllProduct(){
		return new ResponseEntity<>(productSrvice.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping ("/getByid/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
    	
    	return new ResponseEntity<>(productSrvice.getProductByid(id),HttpStatus.OK);
    }
	@PutMapping("/update")
	public ResponseEntity<ProductDto> updateProductById(@RequestBody ProductDto productDto){
		;
		return new ResponseEntity<>(productSrvice.updateProduct(productDto),HttpStatus.OK);
	}
	
	
}
