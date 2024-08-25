package com.ronaldosantos.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldosantos.workshopmongo.dominio.User;
import com.ronaldosantos.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	public List<User> findAll(){
		return userrepository.findAll();
	}

}
