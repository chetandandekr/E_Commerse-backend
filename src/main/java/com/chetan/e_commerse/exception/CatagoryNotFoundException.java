package com.chetan.e_commerse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class CatagoryNotFoundException extends RuntimeException{

	public CatagoryNotFoundException(String message) {
		super(message);
	}
}
