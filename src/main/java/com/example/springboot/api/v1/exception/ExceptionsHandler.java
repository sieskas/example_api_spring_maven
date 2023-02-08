package com.example.springboot.api.v1.exception;

import com.example.springboot.domain.exceptions.ExampleApiException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionsHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErreurRest> handleException(Exception exception) {
		// TODO create object ErreurRest
		return ResponseEntity.status(500).body(new ErreurRest());
	}

	@ExceptionHandler(ExampleApiException.class)
	public ResponseEntity<ErreurRest> handleException(ExampleApiException exception) {
		// TODO create object ErreurRest
		return ResponseEntity.status(500).body(new ErreurRest());
	}
}
