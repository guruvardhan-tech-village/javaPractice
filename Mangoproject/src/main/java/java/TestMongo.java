/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lohith
 */
import com.mongodb.client.MongoDatabase;

public class TestMongo {

    public static void main(String[] args) {

        MongoDatabase db = DBConnection.connect();

        System.out.println("MongoDB Connected Successfully");

    }
}
