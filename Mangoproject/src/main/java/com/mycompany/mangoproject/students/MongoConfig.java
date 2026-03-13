/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mangoproject.students;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author guruv
 */
public class MongoConfig {
    private static final String URI="mongodb://localhost:27017";
    public static MongoDatabase getDatabase(){
        MongoClient mongoClient = MongoClients.create(URI);
        return mongoClient.getDatabase("college");
    }
    
}
