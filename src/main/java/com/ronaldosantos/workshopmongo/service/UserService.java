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
	
	public User insert(User obj) {
		return userrepository.insert(obj);
	}
	
	public void delete (String id) {
		userrepository.findById(id).orElseThrow(() -> new ObjectNotFoundException ("Objeto não encontrado"));
		userrepository.deleteById(id);
		}
		
	public User update(User obj) {
		User newObj = findById(obj.getId());
		upDateData(newObj,obj);
		return userrepository.save(newObj);
		
	}

	private void upDateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

}
