package com.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.model.Product;

public interface  ProductRepository extends MongoRepository<Product, String> {

}
