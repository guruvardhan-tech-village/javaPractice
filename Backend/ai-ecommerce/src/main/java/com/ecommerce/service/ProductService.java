package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public String addProduct(Product product) {
        productRepository.save(product);
        return "Prduct added successfully";
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
