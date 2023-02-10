package com.example.springboot.outcall.jsonplaceholder;

import com.example.springboot.api.v1.controleur.PostReponseResource;
import com.example.springboot.domain.exceptions.OutCallException;

public interface JsonPaceHolderPort {

	PostReponseResource getPost(int id) throws OutCallException;
}
