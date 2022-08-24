package com.sakila.database.demo.film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {
    List<Film> findByTitleIgnoreCase(String title);
    List<Film> findByTitleContainingIgnoreCase(String titleString);
    List<Film> findByLanguage_Name(String name);
    List<Film> findByFilmCategory_Name(String name);
    List<Film> findTop5ByOrderByScoreDesc();
}

