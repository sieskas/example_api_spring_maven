package com.example.springboot.api.v1.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springboot.api.resources.InvoiceRequestResource;
import com.example.springboot.api.resources.ItemResource;
import com.example.springboot.domain.model.Invoice;
import com.example.springboot.domain.model.TypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class InvoiceEntityEntityMapperTest {

	private final InvoiceMapper mapper = new InvoiceMapperImpl();

	@Test
	void toModel_valid() {
		// given
		List<ItemResource> itemResources =
				Arrays.asList(
						ItemResource.builder().name("name").type("BOOK").price("10.0").build(),
						ItemResource.builder().name("name2").type("MOVIE").price("20.0").build());
		InvoiceRequestResource invoiceRequestResource =
				InvoiceRequestResource.builder().numAccount("0001").items(itemResources).build();

		// when
		Invoice invoice = mapper.toModel(invoiceRequestResource);

		// then
		assertEquals(invoiceRequestResource.getNumAccount(), invoice.getNumAccount());
		assertEquals(2, invoice.getItems().size());
		assertEquals(itemResources.get(0).getName(), invoice.getItems().get(0).getName());
		assertEquals(TypeEnum.BOOK, invoice.getItems().get(0).getType());
		assertEquals(itemResources.get(0).getPrice(), invoice.getItems().get(0).getPrice().toString());
		assertEquals(itemResources.get(1).getName(), invoice.getItems().get(1).getName());
		assertEquals(TypeEnum.MOVIE, invoice.getItems().get(1).getType());
		assertEquals(itemResources.get(1).getPrice(), invoice.getItems().get(1).getPrice().toString());
	}

	@Test
	void toModel_null() {
		assertNull(mapper.toModel((InvoiceRequestResource) null));
		assertNull(mapper.toModel((ItemResource) null));
	}

	@Test
	void toModel_invalid() {
		InvoiceRequestResource invoiceRequestResource =
				InvoiceRequestResource.builder()
						.numAccount("0001")
						.items(
								Collections.singletonList(
										ItemResource.builder().name("name3").type("INVALID").price("30.0").build()))
						.build();
		assertThrows(IllegalArgumentException.class, () -> mapper.toModel(invoiceRequestResource));
	}
}
