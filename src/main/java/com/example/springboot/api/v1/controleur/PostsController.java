package com.example.springboot.api.v1.controleur;

import static com.example.springboot.api.shared.ApiPaths.*;

import com.example.springboot.domain.exceptions.ExampleApiException;
import com.example.springboot.service.PostService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(API_BASE_PATH)
@RequiredArgsConstructor
public class PostsController {

	private final PostService postService;

	@GetMapping(API_END_POINT_POSTS)
	public ResponseEntity<PostReponseResource> doCreateInvoice(
			@RequestHeader MultiValueMap<String, String> headers,
			@ModelAttribute PostRequeteRessource postRequeteRessource,
			HttpServletRequest httpServletRequest)
			throws ExampleApiException {

		return new ResponseEntity<>(postService.getPost(postRequeteRessource.getId()), HttpStatus.OK);
	}
}
