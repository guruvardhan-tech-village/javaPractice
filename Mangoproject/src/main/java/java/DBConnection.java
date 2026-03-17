/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lohith
 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DBConnection {

    public static MongoDatabase connect() {

        MongoClient client = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase db = client.getDatabase("librarydb");

        return db;
    }
}