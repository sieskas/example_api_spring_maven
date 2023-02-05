package com.example.springboot.domain.exceptions;

import org.springframework.http.HttpStatus;

public class ExampleApiException extends Exception {
	private final HttpStatus status;
	private final MessageError messageError;
	private final TypeError typeError;
	private final String message;

	public ExampleApiException() {
		this.status = HttpStatus.INTERNAL_SERVER_ERROR;
		this.messageError = null;
		this.typeError = null;
		this.message = null;
	}

	public ExampleApiException(
			HttpStatus status, MessageError messageError, TypeError typeError, String message) {
		super(messageError.getDescription());
		this.status = status;
		this.messageError = messageError;
		this.typeError = typeError;
		this.message = message;
	}
}
