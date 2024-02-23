package com.bytecode.core.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service("serviceDos")
public class PostServiceImplDos implements PostService {

	@Override
	public List<Post> validation(List<Post> posts) {
		System.out.println("En - validation Segundo Servicio");
		// TODO Auto-generated method stub
		for(Post post : posts) {
			if(post.getId() == 0) {
				throw new NullPointerException("El ID esta nulo");
			}
		}
		return posts;
	}

}
