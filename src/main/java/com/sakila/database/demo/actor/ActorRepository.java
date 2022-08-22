package com.sakila.database.demo.actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<actor, Integer> {
    //find list of actors that have a first name given as a string
    List<actor> findByFirstName(String firstname);

    //@Query(value = "SELECT * FROM actor WHERE first_name= ?1 AND last_name=?2", nativeQuery = true)
    List<actor> findByFirstNameAndLastName(String firstname, String lastname);

    //return actors that are in a particular film
    List<actor> findByFilms_Title(String title);

    //return an actor whos name is half containing
    List<actor> findByFirstNameContainingIgnoreCase(String nameString);
    List<actor> findByLastNameContainingIgnoreCase(String nameString);
}
