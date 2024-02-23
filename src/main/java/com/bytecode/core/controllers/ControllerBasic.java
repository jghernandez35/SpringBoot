package com.bytecode.core.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.configuration.Paginas;
import com.bytecode.core.model.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {

	@Autowired
	private PostComponent _postComponent;
	/* se corta y se pega en PostComponent para usar el @Autowired y el _postComponent
	public List<Post> getPosts(){
		ArrayList<Post> post = new ArrayList<>();
		post.add(new Post(1,"El desarrollo web es un proceso complejo que implica la creación de productos digitales en línea.","http://localhost/img/post.JPG", new Date(),"1Desarrollo WEB"));
		post.add(new Post(2,"Que implica la creación de productos digitales en línea.","http://localhost/img/post1.JPG", new Date(),"2Desarrollo WEB"));
		post.add(new Post(3,"Web es un proceso complejo que implica la creación de productos digitales en línea.","http://localhost/img/post2.JPG", new Date(),"3Desarrollo WEB"));
		post.add(new Post(4,"Desarrollo web es un proceso complejo que implica la creación de productos digitales en línea.","http://localhost/img/post3.JPG", new Date(),"4Desarrollo WEB"));
		return post;
	}*/

	@GetMapping(path = {/*"/post",*/"/"})
	public String saludar(Model model) {
		model.addAttribute("posts", this._postComponent.getPosts());
		return "index";
	}

	@GetMapping(path = {"/post","/post/{post}"})
	public ModelAndView getPostIndividual(
			/*@RequestParam(defaultValue = "1", name = "id", required = false)*/ 
			@PathVariable(required = true, name = "post") int id
			
			) {
		ModelAndView modelAndView = new ModelAndView(Paginas.POST);
		List<Post> postFiltrado = this._postComponent.getPosts().stream()
										.filter( (p) -> {
											return p.getId() == id;
										}).collect(Collectors.toList());
		modelAndView.addObject("posts",postFiltrado.get(0));
		return modelAndView;
	}
	
	@GetMapping("/postNew")
	public ModelAndView getForm() {
		return new ModelAndView("form").addObject("post", new Post());
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(Post post, Model model) {
		List<Post> posts = this._postComponent.getPosts();
		posts.add(post);
		model.addAttribute("posts",posts);
		return "index";
	}
	
	/*@GetMapping(path = {"/post"})
	public ModelAndView getPostIndividual(
			@RequestParam(defaultValue = "1", name = "id", required = false) int id
			) {
		ModelAndView modelAndView = new ModelAndView(Paginas.POST);
		List<Post> postFiltrado = this.getPosts().stream()
										.filter( (p) -> {
											return p.getId() == id;
												}).collect(Collectors.toList());
		modelAndView.addObject("posts",postFiltrado.get(0));
		return modelAndView;
	}*/
	/*@GetMapping(path="/public")
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
		modelAndView.addObject("posts", this.getPosts());
		return modelAndView;
	}*/
}
