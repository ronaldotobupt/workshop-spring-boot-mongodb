package com.ronaldosantos.workshopmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ronaldosantos.workshopmongo.dominio.Post;
import com.ronaldosantos.workshopmongo.dominio.User;
import com.ronaldosantos.workshopmongo.service.UserService;


@RestController
@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService userservice;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findall(){
		List<User> list = userservice.findAll();
		return ResponseEntity.ok().body(list);
		}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable  String id){
		User obj = userservice.findById(id);
		return ResponseEntity.ok().body(obj);
		}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody  User obj){
		obj = userservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	} 
	
	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> delete (@PathVariable String id){
		userservice.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@RequestBody  User obj,@PathVariable String id){
		obj.setId(id);
		obj = userservice.update(obj);
		return ResponseEntity.ok().body(obj);
	} 
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable  String id){
		User obj = userservice.findById(id);
		return ResponseEntity.ok().body(obj.getPost());
		}
	

}
