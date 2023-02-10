package com.example.springboot.domain.exceptions;

import org.springframework.http.HttpStatus;

public class OutCallException extends Exception {
	public OutCallException(HttpStatus statusCode, String message) {}
}
