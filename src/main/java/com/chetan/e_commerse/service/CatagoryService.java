package com.chetan.e_commerse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.chetan.e_commerse.dto.CatagoryDto;
import com.chetan.e_commerse.entity.Catagory;
import com.chetan.e_commerse.mapper.CatagoryMapper;
import com.chetan.e_commerse.reposietry.CatagoryRepositery;

@Service
public class CatagoryService {

	@Autowired
	private CatagoryRepositery catagoryRepositery;
	
	public CatagoryDto createCatagory(CatagoryDto catagoryDto) {
		Catagory catagory=CatagoryMapper.toCtagoryEntity(catagoryDto);
		catagory=catagoryRepositery.save(catagory);
		return CatagoryMapper.toCatagoryDto(catagory);
		
	}
	
	public List<CatagoryDto> getAllCatagory() {
	return	catagoryRepositery.findAll().stream().map(CatagoryMapper::toCatagoryDto).toList();
	}

//	public CatagoryDto updateCatagory(CatagoryDto catagoryDto) {
//		// TODO Auto-generated method stub
//		Catagory catagory=CatagoryMapper.toCtagoryEntity(catagoryDto);
//		catagory=catagoryRepositery.update
//		return CatagoryMapper.toCatagoryDto(catagory);
//	}

	public CatagoryDto getCatagoryById(Long id) {
		// TODO Auto-generated method stub
		Catagory catagory= catagoryRepositery.getById(id);
		return CatagoryMapper.toCatagoryDto(catagory);
		
	}

	public String deleteCatagoryById(Long id) {
		// TODO Auto-generated method stub
		catagoryRepositery.deleteById(id);
		return "delete catagory by id";
	}
	
}
