package com.ronaldosantos.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ronaldosantos.workshopmongo.dominio.Post;
import com.ronaldosantos.workshopmongo.dominio.User;
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
		
		Post post1 = new Post(null,Instant.parse("2018-03-21T19:53:07Z"),"Partir Viagem","Vou viajar para São Paulo abraços!",maria);
		Post post2 = new Post(null,Instant.parse("2018-03-23T19:53:07Z"),"Bom dia","Acordei Feliz hoje!",maria);
		
		postRepository.saveAll(Arrays.asList(post1,post2));
	}

}
