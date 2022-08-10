package com.sakila.database.demo.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/country")
public class CountryController {
    public CountryRepository countryRepository;
    @Autowired
    public void CountryController(CountryRepository countryRepository){this.countryRepository=countryRepository;}

    //get all countries
    @GetMapping("/all")
    public @ResponseBody
    Iterable<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    //get country by ID
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Country> getCountryById(@PathVariable(name="id") int id) {
        return countryRepository.findById(id);
    }

    //get country by name
    @GetMapping("/country/{city}")
    public @ResponseBody
    List<Country> CountryName(@PathVariable(name="country") String country){
        return countryRepository.findByCountry(country);
    }


}
