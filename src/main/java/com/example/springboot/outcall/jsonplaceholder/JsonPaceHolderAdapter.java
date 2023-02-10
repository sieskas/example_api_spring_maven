package com.example.springboot.outcall.jsonplaceholder;

import com.example.springboot.api.v1.controleur.PostReponseResource;
import com.example.springboot.domain.exceptions.OutCallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
public class JsonPaceHolderAdapter implements JsonPaceHolderPort {

    private static final Logger logger = LoggerFactory.getLogger(JsonPaceHolderAdapter.class);

    private WebClient webClient;

    public JsonPaceHolderAdapter(@Qualifier("jsonPlaceHolderWebClient") WebClient webClient) {
        this.webClient = webClient;
    }
    @Override
    public PostReponseResource getPost(int id) throws OutCallException {
        try {
            Mono<PostReponseResource> postReponseResourceMono = webClient.get()
                    .uri("/posts/{id}", id)
                    .retrieve()
                    .bodyToMono(PostReponseResource.class);
            return postReponseResourceMono.block(); // mapper add
        } catch (WebClientResponseException e) {
            throw new OutCallException(e.getStatusCode(), e.getMessage());
        } catch (Exception e) {
            throw new OutCallException(null, e.getMessage());
        }
    }
}
