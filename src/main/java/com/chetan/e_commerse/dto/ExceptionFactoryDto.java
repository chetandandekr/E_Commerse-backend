package com.chetan.e_commerse.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFactoryDto {
	
	public ExceptionResponceDto create(String descrpition , HttpStatus status,String msg,LocalDateTime dateAndTime) {
		return new ExceptionResponceDto(descrpition, msg, status, dateAndTime);
	}

}
