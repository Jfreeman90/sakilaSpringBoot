package com.sakila.database.demo.language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LanguageRepository extends CrudRepository<language,Integer>{
    List<language> findByName(String name);
}
