package com.example.springboot.api.v1.controleur;

import static com.example.springboot.api.shared.ApiPaths.API_BASE_PATH;
import static com.example.springboot.api.shared.ApiPaths.API_END_POINT_INVOICE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.springboot.api.resources.InvoiceRequestResource;
import com.example.springboot.api.v1.mappers.InvoiceMapper;
import com.example.springboot.domain.exceptions.ExampleApiException;
import com.example.springboot.service.InvoiceService;
import java.lang.invoke.MethodHandles;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(API_BASE_PATH)
@RequiredArgsConstructor
public class InvoiceController {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private final InvoiceService invoiceService;
	private final InvoiceMapper exampleMapper;

	@PostMapping(
			value = API_END_POINT_INVOICE,
			produces = {APPLICATION_JSON_VALUE},
			consumes = {APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> doCreateInvoice(
			@RequestHeader MultiValueMap<String, String> headers,
			@RequestBody InvoiceRequestResource invoiceRequestResource,
			HttpServletRequest httpServletRequest)
			throws ExampleApiException {

		String a = null;
		a.toString();

		invoiceService.createInvoice(exampleMapper.toModel(invoiceRequestResource));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
