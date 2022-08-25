package com.sakila.database.demo.address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/city")
public class CityController {
    private CityRepository cityRepository;
    @Autowired
    public void cityControllerWired(CityRepository cityRepository){this.cityRepository=cityRepository;}

    //get all cities
    @GetMapping("/all")
    public @ResponseBody
    Iterable<City> getAllCities(){
        return cityRepository.findAll();
    }

    //get city by ID
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<City> getCityById(@PathVariable(name="id") int id) {
        return cityRepository.findById(id);
    }

    //get city by name
    @GetMapping("/city/{city}")
    public @ResponseBody
    List<City> cityName(@PathVariable(name="city") String city){
        return cityRepository.findByCity(city);
    }

}
