package com.example.springboot.businesslogic;

import com.example.springboot.domain.exceptions.InvalidRequestException;
import com.example.springboot.domain.model.Invoice;
import org.springframework.stereotype.Component;

@Component
public class VerifyInvoiceAccountNumber {
	public void verifyInvoiceAccountNumber(Invoice invoice) throws InvalidRequestException {
		if (invoice == null || invoice.getNumAccount() == null) {
			throw new InvalidRequestException("Account number is required");
		}

		if (!invoice.getNumAccount().matches("\\d{11}")) {
			throw new InvalidRequestException("Account number must be 11 numbers");
		}
	}
}
