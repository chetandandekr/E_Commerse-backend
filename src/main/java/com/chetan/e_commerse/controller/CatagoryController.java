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
import com.chetan.e_commerse.service.CatagoryService;



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
	public ResponseEntity<CatagoryDto> createCatagory(@RequestBody CatagoryDto catagoryDto) {
		return new ResponseEntity<> (catagoryService.createCatagory(catagoryDto),HttpStatus.CREATED);
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
