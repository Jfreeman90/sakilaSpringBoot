package com.sakila.database.demo.User;

import com.sakila.database.demo.Actor.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String firstname);
    User findByEmail(String firstname);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
