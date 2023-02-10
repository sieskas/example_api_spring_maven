package com.example.springboot.outcall.jsonplaceholder;

import com.example.springboot.outcall.BasePostStub;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Configuration("jsonPaceHolderAdapterConfig")
public class JsonPaceHolderAdapterConfig {
    @ConditionalOnProperty(name = "app.outcall.jsonplaceholder.mock.enabled", havingValue = "false", matchIfMissing = true)
    @Bean("jsonPlaceHolderWebClient")
    public WebClient jsonPlaceHolderWebClient(@Value("${app.outcall.jsonplaceholder.url}") String url) {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @ConditionalOnProperty(name = "app.outcall.jsonplaceholder..mock.enabled", havingValue = "true")
    @Bean("jsonPlaceHolderBasePortStub")
    public BasePostStub jsonPlaceHolderWireMock(@Value("${app.outcall.jsonplaceholder.mock.directory}") String wiremockbaseDirectory,
                                                @Value("${app.outcall.jsonplaceholder.mock.port:18080}") int wiremockPort) {
        return new BasePostStub(new WireMockServer(options().
                port(wiremockPort).
                usingFilesUnderDirectory(wiremockbaseDirectory)
                .containerThreads(100)
                .jettyAcceptors(50)
                .disableRequestJournal()));
    }

    @ConditionalOnProperty(name = "app.outcall.jsonplaceholder.mock.enabled", havingValue = "true")
    @Bean("jsonPlaceHolderWebClient")
    public WebClient jsonPlaceHolderWebClientStub(@Qualifier("jsonPlaceHolderBasePortStub") BasePostStub basePostStub) {
        return WebClient.builder()
                .baseUrl("http://localhost:" + basePostStub.getWireMockServer().port())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}

