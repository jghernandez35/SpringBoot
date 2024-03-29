package com.bytecode.core.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service("serviceDecorado")
public class PostServiceDecoradoImpl implements PostService {
	private final Log log = LogFactory.getLog(getClass());

	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@Autowired
	private PostServiceImplDos postServiceImplDos;
	
	@Override
	public List<Post> validation(List<Post> posts) throws NullPointerException {
		log.debug(posts);
		posts = postServiceImpl.validation(posts);
		posts = postServiceImplDos.validation(posts);
		for(Post post : posts) {
			if(post.getDescripcion() == null) {
				
				throw new NullPointerException("La Descripcion es nulo");
			}
			if(post.getFecha() == null) {
				throw new NullPointerException("La Fecha es nulo");
			}			
		}
		//System.out.println("Esta es la clase decorada");
		return posts;
	}

}
