package com.ai_ecommerce.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai_ecommerce.ecommerce.model.Products;
import com.ai_ecommerce.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public String addProducts(Products products){
        productRepository.save(products);
        return "Product added successfully\n"+ 
        "Name: "+products.getName()+
        "\tDescription: "+products.getDescription()+
        "\tPrice: "+products.getPrice()+
        "\tCompany Name: "+products.getCompanyName();
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Products> findByCompanyName(String companyName) {
        return productRepository.findByCompanyName(companyName);
    }
    public List<Products> findByPriceBetween(double min, double max){
        return productRepository.findByPriceBetween(min, max);
    }
}
