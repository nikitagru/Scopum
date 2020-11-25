package com.example.scopum.repository;

import com.example.scopum.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long chat_id);
}
