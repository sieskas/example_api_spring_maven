package com.example.springboot.service;

import com.example.springboot.api.v1.controleur.PostReponseResource;
import com.example.springboot.domain.exceptions.ExampleApiException;
import com.example.springboot.domain.exceptions.MessageError;
import com.example.springboot.domain.exceptions.OutCallException;
import com.example.springboot.outcall.jsonplaceholder.JsonPaceHolderAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final JsonPaceHolderAdapter jsonPaceHolderAdapter;

	@Override
	public PostReponseResource getPost(int id) throws ExampleApiException {
		try {
			return jsonPaceHolderAdapter.getPost(id);
		} catch (OutCallException e) {
			throw new ExampleApiException(MessageError.INTERNAL_ERROR, e);
		}
	}
}
