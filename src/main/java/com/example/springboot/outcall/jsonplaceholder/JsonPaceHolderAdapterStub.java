package com.example.springboot.outcall.jsonplaceholder;

import com.example.springboot.outcall.BasePostStub;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@ConditionalOnProperty(name = "app.outcall.jsonplaceholder.mock.enabled", havingValue = "true")
@Component
public class JsonPaceHolderAdapterStub {
    private BasePostStub basePostStub;

    public JsonPaceHolderAdapterStub(BasePostStub basePostStub) {
        this.basePostStub = basePostStub;
        init();
    }

    private void init() {
        basePostStub.getWireMockServer()
                .stubFor(get(urlMatching("/posts/1"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile("jsonplaceholder/post1.json")));
        basePostStub.getWireMockServer()
                .stubFor(get(urlMatching("/posts/2"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile("jsonplaceholder/post2.json")));
    }
}
