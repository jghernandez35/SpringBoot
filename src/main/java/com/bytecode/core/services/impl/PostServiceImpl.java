package com.bytecode.core.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service("serviceUno")
public class PostServiceImpl implements PostService {
	private final Log log = LogFactory.getLog(getClass());

	@Override
	public List<Post> validation(List<Post> posts) throws NullPointerException {
		//System.out.println("En - validation Primer Servicio");
		log.info("Log Servicio 1");
		// TODO Auto-generated method stub
		for(Post post : posts) {
			if(post.getTitulo() == null) {
				throw new NullPointerException("El titulo esta nulo");
			}
		}
		return posts;
	}

}
