package com.example.scopum.repository;

import com.example.scopum.controller.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByChatId(long chatId);
}
