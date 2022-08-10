package com.sakila.database.demo.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
