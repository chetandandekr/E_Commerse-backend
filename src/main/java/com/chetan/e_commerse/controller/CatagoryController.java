package com.chetan.e_commerse.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.e_commerse.dto.CatagoryDto;
import com.chetan.e_commerse.exception.ResourceAlreadyExists;
import com.chetan.e_commerse.service.CatagoryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
		name="Catagory REST API Service",
		description="CREATE,READ,DELETE AND UPDATE REST API ")

@RestController
@RequestMapping("/api/catagory")
public class CatagoryController {
	
	@Autowired
	private CatagoryService catagoryService;

	@GetMapping("/GetAllCatagory")
	//@component-> find the class create the spring bean handle the depenedencies inject the beans 
	//@configuration-> spring that designates a class as a source of bean definitions.
	//@controller-> maps http request to these method ,also handle view resolution e.g. returning html pages or templates
	//@restcontroller-> combines the behavier of contriier and responsebody. when building rest apis that return jason data directly insted of views.
	//rest api -> reprentational state transfer. communaction two apps.client sever communation model, stateless comunaction.  
	public ResponseEntity<List<CatagoryDto>> getAllCatagory(){
		return new ResponseEntity<> (catagoryService.getAllCatagory(),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createCatagory(@RequestBody CatagoryDto catagoryDto) {
		
		//if we  have the global exception we dont have to handle by try catch in  controller class.
		
//		try {
//			CatagoryDto savecatagory= catagoryService.createCatagory(catagoryDto);
//			return ResponseEntity.status(HttpStatus.CREATED).body(savecatagory);
//		} catch (ResourceAlreadyExists e) {
//			// TODO: handle exception
//			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//		}
	
		CatagoryDto savecatagory= catagoryService.createCatagory(catagoryDto);
      	return ResponseEntity.status(HttpStatus.CREATED).body(savecatagory);
	}
	
//	@PutMapping("/update")
//	public ResponseEntity<CatagoryDto> updateCatagory(@RequestBody CatagoryDto catagoryDto){
//		return new ResponseEntity<>(catagoryService.updateCatagory(catagoryDto),HttpStatus.OK);
//	}
	
	@GetMapping("/getbyid/{id}")
	public CatagoryDto getCatagoryById(@PathVariable Long id) {
		return catagoryService.getCatagoryById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCatagoryById(@PathVariable Long id) {
		catagoryService.deleteCatagoryById(id);
		return "delete succefully";
	}
	
	
	
}
