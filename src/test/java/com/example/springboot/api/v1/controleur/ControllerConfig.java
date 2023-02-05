package com.example.springboot.api.v1.controleur;

import com.example.springboot.api.v1.mappers.InvoiceMapper;
import com.example.springboot.service.InvoiceService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ControllerConfig {
	@MockBean private InvoiceMapper exampleMapper;
	@MockBean private InvoiceService postsService;

	@Bean
	InvoiceController exampleController() {
		return new InvoiceController(postsService, exampleMapper);
	}
}
