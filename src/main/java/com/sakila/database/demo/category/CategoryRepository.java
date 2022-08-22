package com.sakila.database.demo.category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<category, Integer> {
    List<category> findByName(String name);
}
