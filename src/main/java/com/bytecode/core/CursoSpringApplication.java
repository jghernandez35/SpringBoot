package com.bytecode.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.services.PostService;
import com.bytecode.core.services.impl.PostServiceImpl;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner{

	//forma de inyectar un componente
	@Autowired
	@Qualifier("com.bytecode.core.components.PostComponent")
	public PostComponent postComponent;
	
	// Las 3 formas de inyectar son 
	//1- Por campo usando @Autowired y @Qualifier
	//2- Por el metodo SET
	//3- Por un constructor
	
	//forma de inyectar un servicio usando @Autowired y @Qualifier para especificar el nombre
	//@Autowired
	//@Qualifier("serviceDecorado")
	public PostService postService;
	
	
	public PostService getPostService() {
		return postService;
	}
	
	//Forma de inyectar usando el metodo SET
	@Autowired
	@Qualifier("serviceDecorado")
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	
	//Forma de inyectar usando el Constructor
	public CursoSpringApplication() {
		
	}
	
	//Forma de inyectar usando el Constructor
	@Autowired
	public CursoSpringApplication(@Qualifier("serviceDecorado") PostService postService) {
		this.postService = postService;
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//postComponent.getPosts().forEach(p -> {
		//	System.out.println(p.getDescripcion());});
		Log log = LogFactory.getLog(getClass());
		try {
			postService.validation(postComponent.getPosts())
				.forEach((post) -> {
					System.out.println("==> "+post.getTitulo());
				});
		}catch (Exception e){
			System.out.print(e.getMessage());
		}
	}
}
