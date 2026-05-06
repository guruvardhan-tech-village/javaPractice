package com.mongoatlas.practiceatlas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongoatlas.practiceatlas.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}