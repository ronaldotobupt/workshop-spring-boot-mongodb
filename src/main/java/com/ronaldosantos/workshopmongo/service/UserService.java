package com.ronaldosantos.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldosantos.workshopmongo.dominio.User;
import com.ronaldosantos.workshopmongo.repository.UserRepository;
import com.ronaldosantos.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	public List<User> findAll(){
		return userrepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userrepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException ("Objeto não encontrado"));
	}

}
