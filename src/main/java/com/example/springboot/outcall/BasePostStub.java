package com.example.springboot.outcall;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.Getter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(prefix = "app", name="security.enabled", havingValue = "false")
@Getter
public class BasePostStub {

    private WireMockServer wireMockServer;

    public BasePostStub(WireMockServer wireMockServer) {
        this.wireMockServer = wireMockServer;
        wireMockServer.start();
    }
}
