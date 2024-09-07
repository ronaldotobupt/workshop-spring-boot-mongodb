package com.ronaldosantos.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldosantos.workshopmongo.dominio.Post;
import com.ronaldosantos.workshopmongo.service.PostService;


@RestController
@RequestMapping(value ="/posts")
public class PostResource {
	
	@Autowired
	private PostService postservice;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable  String id){
		Post obj = postservice.findById(id);
		return ResponseEntity.ok().body(obj);
		}
	
	
}
