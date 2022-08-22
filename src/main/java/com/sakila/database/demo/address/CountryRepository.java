package com.sakila.database.demo.address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<country, Integer> {
    List<country> findByCountry(String country);
}
