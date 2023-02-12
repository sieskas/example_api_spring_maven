package com.example.springboot.api.v1.controleur;

import com.example.springboot.domain.exceptions.ExampleApiException;
import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(ControllerConfig.class)
class InvoiceControllerTest {

	@Autowired private InvoiceController invoiceController;
	@Mock private HttpServletRequest httpServletRequest;

	@Test
	void doExample_ok() throws ExampleApiException {
		//		ResponseEntity<Void> reponseEntity =
		//				invoiceController.doCreateInvoice(
		//						null,
		//						InvoiceRequestResource.builder()
		//								.items(Collections.singletonList(ItemResource.builder().build()))
		//								.build(),
		//						httpServletRequest);
		//		assertEquals(HttpStatus.CREATED, reponseEntity.getStatusCode());
	}
}
