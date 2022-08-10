package com.sakila.database.demo.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{
    List<Address>findByCity_City(String city);
    List<Address>findByCity_Country_Country(String country);
}
