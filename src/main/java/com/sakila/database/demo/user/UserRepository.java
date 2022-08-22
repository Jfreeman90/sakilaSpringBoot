package com.sakila.database.demo.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<user, Integer> {
    user findByUsername(String firstname);
    user findByEmail(String firstname);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
