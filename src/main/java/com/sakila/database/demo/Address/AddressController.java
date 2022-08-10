package com.sakila.database.demo.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/address")
public class AddressController {
    public AddressRepository addressRepository;
    @Autowired
    public void AddressController(AddressRepository addressRepository){this.addressRepository=addressRepository;}

    //get all address
    @GetMapping("/all")
    public @ResponseBody
    Iterable<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    //get address by ID
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Address> getAddressById(@PathVariable(name="id") int id) {
        return addressRepository.findById(id);
    }

    //get all address' in a particular city
    @GetMapping("/get_by_city")
    public @ResponseBody
    List<Address> getAddressByCity(@RequestParam String city) {
        return addressRepository.findByCity_City(city);
    }

    //get all address in a particular country
    @GetMapping("/get_by_country")
    public @ResponseBody
    List<Address> getAddressByCountry(@RequestParam String country) {
        return addressRepository.findByCity_Country_Country(country);
    }
}
