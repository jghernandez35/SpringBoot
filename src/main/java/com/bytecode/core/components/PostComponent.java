package com.bytecode.core.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bytecode.core.model.Post;

@Component("com.bytecode.core.components.PostComponent")
public class PostComponent {

	public List<Post> getPosts(){
		ArrayList<Post> post = new ArrayList<>();
		//System.out.println("En - PostComponent");
		post.add(new Post(0,"El desarrollo web es un proceso complejo que implica la creación de productos digitales en línea.","http://localhost/img/post.JPG", new Date(),"1_Desarrollo WEB"));
		post.add(new Post(2,"Que implica la creación de productos digitales en línea.","http://localhost/img/post1.JPG", new Date(),"2_Desarrollo Descktop"));
		post.add(new Post(3,"Web es un proceso complejo que implica la creación de productos digitales en línea.","http://localhost/img/post2.JPG", new Date(),"3_Desarrollo Frond-End"));
		post.add(new Post(4,"Desarrollo web es un proceso complejo que implica la creación de productos digitales en línea.","http://localhost/img/post3.JPG", new Date(),"4_Desarrollo Back-End"));
		return post;
	}
	
}
