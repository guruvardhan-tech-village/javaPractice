package com.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.model.Product;
import java.util.List;


public interface  ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByCategory(String category);
    List<Product> findByPriceBetween(Double min, Double max);
    List<Product> findByCompanyName(String companyName);

}
