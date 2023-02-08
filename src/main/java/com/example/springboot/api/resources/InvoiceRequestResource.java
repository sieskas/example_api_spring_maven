package com.example.springboot.api.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequestResource {

	@JsonProperty("accountNumber")
	private String numAccount;

	@JsonProperty("itemsList")
	private List<ItemResource> items;
}
