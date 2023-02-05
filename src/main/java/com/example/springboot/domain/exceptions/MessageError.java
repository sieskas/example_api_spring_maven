package com.example.springboot.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageError {
	INTERNAL_ERROR("An internal error has occurred. Please try again later."),
	INVALID_REQUEST("The request is invalid. Please check your input and try again."),
	INVALID_FIELD("One or more fields are invalid. Please check your input and try again.");

	private final String description;
}
