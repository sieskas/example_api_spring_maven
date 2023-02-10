package com.example.springboot.functionals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.springboot.api.resources.InvoiceRequestResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;

@CucumberContextConfiguration
public class StepDefinitions extends CucumberTestBase {

	private final RequestSpecification requestSpecifination;
	private Response response;

	public StepDefinitions() {
		this.requestSpecifination = RestAssured.given().port(8080).contentType(ContentType.JSON);
	}

	@Given("the user is authenticated")
	public void theUserIsAuthenticated() {}

	@When("the user sends a POST {} to invoices")
	public void theUserSendsAPOSTRequestToInvoices(String request) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		InvoiceRequestResource invoice =
				objectMapper.readValue(
						this.getClass()
								.getClassLoader()
								.getResourceAsStream("com/example/springboot/functionals/json/" + request),
						InvoiceRequestResource.class);
		requestSpecifination.body(invoice);
		response = requestSpecifination.request(Method.POST, "/api/example/spring/v1/invoice");
	}

	@Then("the system will create the invoice and return the invoice number with {}")
	public void theSystemWillCreateTheInvoiceAndReturnTheInvoiceNumberWithHttp_code(int httpCode) {
		assertEquals(httpCode, response.getStatusCode());
	}
}
