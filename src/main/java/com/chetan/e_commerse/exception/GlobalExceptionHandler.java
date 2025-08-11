package com.chetan.e_commerse.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.chetan.e_commerse.dto.ExceptionFactoryDto;
import com.chetan.e_commerse.dto.ExceptionResponceDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	ExceptionFactoryDto exceptionDto;

	@ExceptionHandler(ResourceAlreadyExists.class)
	public ResponseEntity<ExceptionResponceDto> resourceAlreadyExistsException(ResourceAlreadyExists ex, WebRequest webRequest){
	 ExceptionResponceDto exceptionsaveDto=exceptionDto.create( webRequest.getDescription(false),HttpStatus.CONFLICT,ex.getMessage(),LocalDateTime.now()); 
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionsaveDto);
	}
	
	@ExceptionHandler(CatagoryNotFoundException.class)
	public ResponseEntity<String> catgoryNotFound(CatagoryNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
