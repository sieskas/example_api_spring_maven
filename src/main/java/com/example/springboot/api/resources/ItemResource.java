package com.example.springboot.api.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResource {
	@JsonProperty("nameItem")
	private String name;

	@JsonProperty("typeItem")
	private String type;

	@JsonProperty("priceItem")
	private String price;
}
