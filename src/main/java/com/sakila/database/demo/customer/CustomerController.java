package com.sakila.database.demo.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {
    //create object and wire to sql database 'customer'
    public CustomerRepository customerRepository;
    @Autowired
    public void customerControllerWired(CustomerRepository customerRepository){
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

    //Get request for a specific customer using a request parameter instead of a fixed url look up.
    @GetMapping("/ID")
    public @ResponseBody Optional<Customer> customerById(@RequestParam int id){
        return customerRepository.findById(id);
    }

    //add a new customer
    @PostMapping("/add")
    public @ResponseBody
    String addNewCustomer(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
                            @RequestParam int storeId, @RequestParam int addressId){
        Customer customer = new Customer(firstName, lastName, email, storeId, addressId);
        customerRepository.save(customer);
        return "Saved";
    }

}
