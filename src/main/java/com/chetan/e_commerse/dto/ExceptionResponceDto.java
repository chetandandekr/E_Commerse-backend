package com.chetan.e_commerse.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponceDto {

	private String apiPath;
	private String errorMessage;
	private HttpStatus statusCode;
	private LocalDateTime localTime;
	
}
