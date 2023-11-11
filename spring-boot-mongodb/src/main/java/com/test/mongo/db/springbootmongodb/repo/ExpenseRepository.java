package com.test.mongo.db.springbootmongodb.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.test.mongo.db.springbootmongodb.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String>{
	
	@Query("{ 'name' : ?0 }")
	Optional<Expense> findByName(String name);

}
