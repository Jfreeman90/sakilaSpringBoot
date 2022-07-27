package com.sakila.database.demo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {
    //create object and wire to sql database 'customer'
    public CustomerRepository customerRepository;
    @Autowired
    public void CustomerController(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    //get all of the customer details on record
    @GetMapping("/all")
    public @ResponseBody
    Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //get a customer details based on id of the url
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Customer> getCustomerById(@PathVariable(name="id") int id) {
        return customerRepository.findById(id);
    }

    //Get request for a specific customer using a request paramater instead of a fixed url look up.
    @GetMapping("/ID")
    public @ResponseBody Optional<Customer> customerById(@RequestParam int id){
        return customerRepository.findById(id);
    }

}
