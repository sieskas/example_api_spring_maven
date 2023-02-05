package com.example.springboot.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeError {
	VALIDATION("V"),
	SYSTEM("S");

	private final String type;
}
