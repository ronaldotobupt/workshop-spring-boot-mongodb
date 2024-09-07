package com.ronaldosantos.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ronaldosantos.workshopmongo.dominio.Post;
import com.ronaldosantos.workshopmongo.dominio.User;
import com.ronaldosantos.workshopmongo.dto.AuthorDTO;
import com.ronaldosantos.workshopmongo.dto.CommentsDTO;
import com.ronaldosantos.workshopmongo.repository.PostRepository;
import com.ronaldosantos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiaton implements CommandLineRunner {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,Instant.parse("2018-03-21T19:53:07Z"),"Partir Viagem","Vou viajar para São Paulo abraços!",new AuthorDTO(maria));
		Post post2 = new Post(null,Instant.parse("2018-03-23T19:53:07Z"),"Bom dia","Acordei Feliz hoje!",new AuthorDTO(maria));
		
		CommentsDTO c1 = new CommentsDTO("Boa Viagem Mano",Instant.parse("2018-03-21T03:01:01Z"),new AuthorDTO(alex));
		CommentsDTO c2 = new CommentsDTO("Aproveite", Instant.parse("2018-03-22T03:01:01Z"),new AuthorDTO(bob));
		CommentsDTO c3 = new CommentsDTO("Tenha um ótimo dia",Instant.parse("2018-03-23T03:01:01Z"),new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		
		maria.getPost().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
	}

}
