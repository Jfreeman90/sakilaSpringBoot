package com.sakila.database.demo.film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<film, Integer> {
    List<film> findByTitleIgnoreCase(String title);
    List<film> findByTitleContainingIgnoreCase(String titleString);

    List<film> findByLanguage_Name(String name);
    List<film> findByFilmCategory_Name(String name);

}

