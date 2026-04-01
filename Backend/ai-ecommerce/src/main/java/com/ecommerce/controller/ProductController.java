package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/products")
@CrossOrigin(origins="*")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    
    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    

}
