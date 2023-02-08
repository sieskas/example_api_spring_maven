package com.example.springboot.service;

import com.example.springboot.domain.exceptions.ExampleApiException;
import com.example.springboot.domain.model.Invoice;

public interface InvoiceService {

	void createInvoice(Invoice invoice) throws ExampleApiException;
}
