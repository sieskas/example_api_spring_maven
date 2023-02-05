package com.example.springboot.businesslogic;

import com.example.springboot.domain.exceptions.InvalidRequestException;
import org.springframework.stereotype.Component;

@Component
public class VerifyInvoiceAccountNumber {
	public void verifyInvoiceAccountNumber(String numAccount) throws Exception {
		if (!numAccount.matches("\\d{11}")) {
			throw new InvalidRequestException("Account number must be 11 numbers");
		}
	}
}
