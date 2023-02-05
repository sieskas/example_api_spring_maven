package com.example.springboot.service;

import com.example.springboot.domain.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public void createInvoice(Invoice invoice) {}
}
