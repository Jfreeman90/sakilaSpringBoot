package com.sakila.database.demo.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String firstname);
    User findByEmail(String firstname);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
