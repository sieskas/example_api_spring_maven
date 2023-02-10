package com.example.springboot.service;

import com.example.springboot.api.v1.controleur.PostReponseResource;
import com.example.springboot.domain.exceptions.ExampleApiException;
import org.springframework.stereotype.Service;

@Service
public interface PostService {


    PostReponseResource getPost(int id) throws ExampleApiException;
}
