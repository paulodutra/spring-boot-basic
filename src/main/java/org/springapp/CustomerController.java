package org.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
