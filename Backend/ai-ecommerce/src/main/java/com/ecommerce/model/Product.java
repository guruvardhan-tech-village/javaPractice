package com.ecommerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="products")
public class Product {
    @Id
    private String id;

    private String name;
    private String description;
    private double price;
    private String category;
    private String companyName;

    public Product(){

    }
    public Product(String name, String description, String price, String category, String companyName) {
        
        this.name = name;
        this.description = description;
        this.price = Double.parseDouble(price);
        this.category = category;
        this.companyName = companyName;

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}