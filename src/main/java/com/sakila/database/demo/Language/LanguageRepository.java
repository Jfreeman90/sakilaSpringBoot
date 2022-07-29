package com.sakila.database.demo.Language;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Integer>{
    List<Language> findByName(String name);
}
