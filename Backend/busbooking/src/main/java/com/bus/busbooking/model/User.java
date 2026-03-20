package com.bus.busbooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")  // This annotation indicates that this class is a MongoDB document and specifies the collection name as "users". When you save an instance of this class to the database, it will be stored in the "users" collection.
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private int age;

    public User(){}

    public User(String name,String email,int age){
        this.name=name;
        this.email=email;
        this.age=age;
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
