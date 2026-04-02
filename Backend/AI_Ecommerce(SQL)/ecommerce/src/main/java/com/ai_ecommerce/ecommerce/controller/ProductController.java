package com.ai_ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ai_ecommerce.ecommerce.model.Products;
import com.ai_ecommerce.ecommerce.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProducts")
    public String addProducts(@RequestBody Products products){
        return productService.addProducts(products);
    }

    @GetMapping("getAllProducts")
    public List<Products> getAllproducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/getProductsByCompanyName")
    public List<Products> getProductsByCompanyName(@RequestParam String companyName){
        return productService.getProductsByCompanyName(companyName);
    }
    @GetMapping("/getProductsByPriceRange")
    public List<Products> getProductsByPriceRange(@RequestParam double min, @RequestParam double max){
        return productService.findByPriceBetween(min, max);
    }
}
