package com.ronaldosantos.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
