package com.ronaldosantos.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldosantos.workshopmongo.dominio.Post;
import com.ronaldosantos.workshopmongo.repository.PostRepository;
import com.ronaldosantos.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postrepository;
	
	public Post findById(String id) {
		Optional<Post> obj = postrepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException ("Objeto não encontrado"));
	}
	
	public List<Post> searchTitle(String text){
		return postrepository.searchTitle(text);
	}
	
}
	
	