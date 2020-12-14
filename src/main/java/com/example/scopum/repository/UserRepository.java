package com.example.scopum.repository;

import com.example.scopum.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Репозиторий для общение с базой данных
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long chat_id);        // найти пользователя по chat id
}
