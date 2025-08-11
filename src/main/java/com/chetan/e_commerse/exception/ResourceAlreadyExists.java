package com.chetan.e_commerse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class ResourceAlreadyExists extends RuntimeException {

	public ResourceAlreadyExists(String message) {
		super(message);
	}
}
