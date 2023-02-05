package com.example.springboot.domain.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidRequestException extends ExampleApiException {

	public InvalidRequestException(String message) {
		super(HttpStatus.BAD_REQUEST, MessageError.INVALID_REQUEST, TypeError.VALIDATION, message);
	}
}
