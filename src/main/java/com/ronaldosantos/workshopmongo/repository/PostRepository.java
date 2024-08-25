package com.ronaldosantos.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ronaldosantos.workshopmongo.dominio.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
