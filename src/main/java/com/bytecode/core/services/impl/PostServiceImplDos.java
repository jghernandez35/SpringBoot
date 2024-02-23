package com.bytecode.core.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service("serviceDos")
public class PostServiceImplDos implements PostService {
	private final Log log = LogFactory.getLog(getClass());

	@Override
	public List<Post> validation(List<Post> posts) throws NullPointerException {
		//System.out.println("En - validation Segundo Servicio");
		log.info("Log Servicio 2");
		// TODO Auto-generated method stub
		for(Post post : posts) {
			if(post.getId() == 0) {
				throw new NullPointerException("El ID esta nulo");
			}
		}
		return posts;
	}

}
