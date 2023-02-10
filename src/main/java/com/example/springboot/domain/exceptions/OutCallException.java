package com.example.springboot.domain.exceptions;

import com.example.springboot.domain.exceptions.ExampleApiException;
import org.springframework.http.HttpStatus;

public class OutCallException extends Exception {
    public OutCallException(HttpStatus statusCode, String message) {
    }
}
