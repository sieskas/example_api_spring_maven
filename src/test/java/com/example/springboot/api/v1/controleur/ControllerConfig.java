package com.example.springboot.api.v1.controleur;

import com.example.springboot.api.v1.mappers.ExampleMapper;
import com.example.springboot.service.PostsService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ControllerConfig {
	@MockBean private ExampleMapper exampleMapper;
	@MockBean private PostsService postsService;

	@Bean
	ExampleController exampleController() {
		return new ExampleController(postsService, exampleMapper);
	}
}
