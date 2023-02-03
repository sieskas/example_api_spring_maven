package com.example.springboot.api.v1.controleur;

import static com.example.springboot.api.shared.ApiPaths.API_BASE_PATH;
import static com.example.springboot.api.shared.ApiPaths.API_END_POINT_EXAMPLE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.springboot.api.resources.ExampleRequestResource;
import java.lang.invoke.MethodHandles;
import javax.servlet.http.HttpServletRequest;

import com.example.springboot.api.v1.mappers.ExampleMapper;
import com.example.springboot.service.PostsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(API_BASE_PATH)
@RequiredArgsConstructor
public class ExampleController {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private final PostsService postsService;
	private final ExampleMapper exampleMapper;

	@PostMapping(
			value = API_END_POINT_EXAMPLE,
			produces = {APPLICATION_JSON_VALUE},
			consumes = {APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> doExample(
			@RequestHeader MultiValueMap<String, String> headers,
			@RequestBody ExampleRequestResource exampleRequestResource,
			HttpServletRequest httpServletRequest) {

		postsService.getPosts(exampleMapper.toModel(exampleRequestResource));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
