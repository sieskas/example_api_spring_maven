package com.example.springboot.outcall.jsonplaceholder;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.example.springboot.outcall.BasePostStub;
import com.github.tomakehurst.wiremock.http.UniformDistribution;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "app.outcall.jsonplaceholder.mock.enabled", havingValue = "true")
@Component
public class JsonPaceHolderAdapterStub {
	private BasePostStub basePostStub;

	public JsonPaceHolderAdapterStub(BasePostStub basePostStub) {
		this.basePostStub = basePostStub;
		init();
	}

	private void init() {
		basePostStub
				.getWireMockServer()
				.stubFor(
						get(urlMatching("/posts/1"))
								.willReturn(
										aResponse()
												.withStatus(200)
												.withHeader("Content-Type", "application/json")
												.withBodyFile("jsonplaceholder/post1.json")
												.withRandomDelay(new UniformDistribution(100, 300))));
		basePostStub
				.getWireMockServer()
				.stubFor(
						get(urlMatching("/posts/2"))
								.willReturn(
										aResponse()
												.withStatus(200)
												.withHeader("Content-Type", "application/json")
												.withBodyFile("jsonplaceholder/post2.json")));
	}
}
