package com.sakila.database.demo.filmactor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {
}
