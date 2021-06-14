package com.meritamerica.assignment5.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotExistException extends Exception {
	
	public NotExistException(String message) {
		super(message);
	}
}

