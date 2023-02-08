package com.example.springboot.businesslogic;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springboot.domain.model.Invoice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VerifyInvoiceAccountNumberTest {

	private final VerifyInvoiceAccountNumber verifyInvoiceAccountNumber =
			new VerifyInvoiceAccountNumber();

	@ParameterizedTest
	@ValueSource(strings = {"123456789", "1234567890A", "1234567890a", "1234567890-", "1234567890 "})
	void verifyInvoiceAccountNumber(String numAccount) {
		assertThrows(
				Exception.class,
				() ->
						verifyInvoiceAccountNumber.verifyInvoiceAccountNumber(
								Invoice.builder().numAccount(numAccount).build()));
	}

	@Test
	void verifyInvoiceAccountNumberValid() throws Exception {
		verifyInvoiceAccountNumber.verifyInvoiceAccountNumber(
				Invoice.builder().numAccount("12345678901").build());
	}
}
