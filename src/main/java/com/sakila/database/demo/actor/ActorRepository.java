package com.sakila.database.demo.actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {
    //find list of actors that have a first name given as a string
    List<Actor> findByFirstName(String firstname);

    //@Query(value = "SELECT * FROM actor WHERE first_name= ?1 AND last_name=?2", nativeQuery = true)
    List<Actor> findByFirstNameAndLastName(String firstname, String lastname);

    //return actors that are in a particular film
    List<Actor> findByFilms_Title(String title);
    //return actors that are in a particular film
    List<Actor> findByFilms_filmId(Integer id);

    //return an actor whos name is half containing
    List<Actor> findByFirstNameContainingIgnoreCase(String nameString);
    List<Actor> findByLastNameContainingIgnoreCase(String nameString);
}
