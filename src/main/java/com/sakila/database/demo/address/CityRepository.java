package com.sakila.database.demo.address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>{
    List<City> findByCity(String city);
}

