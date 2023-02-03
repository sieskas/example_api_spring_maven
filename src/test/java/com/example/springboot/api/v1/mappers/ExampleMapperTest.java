package com.example.springboot.api.v1.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springboot.api.resources.ExampleRequestResource;
import com.example.springboot.api.resources.ItemResource;
import com.example.springboot.domain.model.Example;
import com.example.springboot.domain.model.TypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class ExampleMapperTest {

	private final ExampleMapper mapper = new ExampleMapperImpl();

	@Test
	void toModel_valid() {
		// given
		List<ItemResource> itemResources =
				Arrays.asList(
						ItemResource.builder().name("name").type("BOOK").price("10.0").build(),
						ItemResource.builder().name("name2").type("MOVIE").price("20.0").build());
		ExampleRequestResource exampleRequestResource =
				ExampleRequestResource.builder().numAccount("0001").items(itemResources).build();

		// when
		Example example = mapper.toModel(exampleRequestResource);

		// then
		assertEquals(exampleRequestResource.getNumAccount(), example.getNumAccount());
		assertEquals(2, example.getItems().size());
		assertEquals(itemResources.get(0).getName(), example.getItems().get(0).getName());
		assertEquals(TypeEnum.BOOK, example.getItems().get(0).getType());
		assertEquals(itemResources.get(0).getPrice(), example.getItems().get(0).getPrice().toString());
		assertEquals(itemResources.get(1).getName(), example.getItems().get(1).getName());
		assertEquals(TypeEnum.MOVIE, example.getItems().get(1).getType());
		assertEquals(itemResources.get(1).getPrice(), example.getItems().get(1).getPrice().toString());
	}

	@Test
	void toModel_null() {
		assertNull(mapper.toModel((ExampleRequestResource) null));
		assertNull(mapper.toModel((ItemResource) null));
	}

	@Test
	void toModel_invalid() {
		ExampleRequestResource exampleRequestResource =
				ExampleRequestResource.builder()
						.numAccount("0001")
						.items(
								Collections.singletonList(
										ItemResource.builder().name("name3").type("INVALID").price("30.0").build()))
						.build();
		assertThrows(IllegalArgumentException.class, () -> mapper.toModel(exampleRequestResource));
	}
}
