package com.bus.busbooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bus.busbooking.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}