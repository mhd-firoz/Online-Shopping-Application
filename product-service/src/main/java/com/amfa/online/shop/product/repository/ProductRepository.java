package com.amfa.online.shop.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amfa.online.shop.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
