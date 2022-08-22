package com.sakila.database.demo.address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/city")
public class cityController {
    public CityRepository cityRepository;
    @Autowired
    public void cityControllerWired(CityRepository cityRepository){this.cityRepository=cityRepository;}

    //get all cities
    @GetMapping("/all")
    public @ResponseBody
    Iterable<city> getAllCities(){
        return cityRepository.findAll();
    }

    //get city by ID
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<city> getCityById(@PathVariable(name="id") int id) {
        return cityRepository.findById(id);
    }

    //get city by name
    @GetMapping("/city/{city}")
    public @ResponseBody
    List<city> cityName(@PathVariable(name="city") String city){
        return cityRepository.findByCity(city);
    }

}
