package com.bus.busbooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bus.busbooking.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    // This interface extends MongoRepository, which provides CRUD operations for the User entity. The first generic parameter is the type of the entity (User), and the second parameter is the type of the primary key (String, since the id field in User is a String). By extending MongoRepository, you can perform operations like save, findAll, findById, delete, etc., without needing to implement these methods yourself.
}