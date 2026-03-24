package com.bus.busbooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "users")  // This annotation indicates that this class is a MongoDB document and specifies the collection name as "users". When you save an instance of this class to the database, it will be stored in the "users" collection.
public class User {
    // @Id  //This annotation indicates that the id field is the primary key for this document. When you save a User object to the database, MongoDB will automatically generate a unique identifier for this field if it is not already set.
    // private String id;
    // private String name;
    // private String email;
    // private int age;

    // public User(){}

    // public User(String name,String email,int age){
    //     this.name=name;
    //     this.email=email;
    //     this.age=age;
    // }
    @Id
    private String id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 100, message = "Age should not be greater than 100")
    private int age;

    public User() {}

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
}




