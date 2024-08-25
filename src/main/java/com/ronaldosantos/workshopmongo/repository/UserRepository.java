package com.ronaldosantos.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ronaldosantos.workshopmongo.dominio.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
