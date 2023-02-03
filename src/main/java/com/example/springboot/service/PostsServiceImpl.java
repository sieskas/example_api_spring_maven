package com.example.springboot.service;

import com.example.springboot.domain.model.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

	@Override
	public void getPosts(Example example) {}
}
