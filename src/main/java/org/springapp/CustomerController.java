package org.springapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springapp.entity.Customer;
import org.springapp.entity.repository.CustomerRepository;



@Controller
@RequestMapping(path = "/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    public CustomerController(CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    @GetMapping
    @ResponseBody
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Optional<Customer> findOne(@PathVariable Long id) {
        return Optional.ofNullable(repository.findById(id).orElse(null));
    }

    @GetMapping(path = "/name/{name}")
    @ResponseBody
    public Customer findByName(@PathVariable String name) {
        return repository.findByName(name);
    }

    @PostMapping
    @ResponseBody
    public Customer create(@RequestParam String name, @RequestParam Integer age) {
        Customer customer = new Customer(name, age);
        if(name != null && name.length() > 0 && age != null && age > 0) {
            repository.save(customer);
        }
        return customer;
    }


}
