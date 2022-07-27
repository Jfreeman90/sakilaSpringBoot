package com.sakila.database.demo.Category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {
}
