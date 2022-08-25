package com.sakila.database.demo.address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/country")
public class CountryController {
    private CountryRepository countryRepository;
    @Autowired
    public void countryControllerWired(CountryRepository countryRepository){this.countryRepository=countryRepository;}

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
    @GetMapping("/country/{country}")
    public @ResponseBody
    List<Country> getCountryByName(@PathVariable(name="country") String country){
        return countryRepository.findByCountry(country);
    }


}
