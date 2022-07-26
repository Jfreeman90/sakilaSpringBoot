package com.sakila.database.demo.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {
    //find list of actors that have a first name given as a string
    @Query(value = "SELECT * FROM actor WHERE first_name= ?1", nativeQuery = true)
    List<Actor> findByFirstName(String firstname);
}
