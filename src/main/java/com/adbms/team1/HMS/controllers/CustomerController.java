package com.adbms.team1.HMS.controllers;

import com.adbms.team1.HMS.Model.Customer;
import com.adbms.team1.HMS.Model.FoodOrder;
import com.adbms.team1.HMS.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerServices.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public List<Customer> getCustomerById(@PathVariable Integer id) {
        return customerServices.getCustomerById(id);
    }

    @PutMapping("/delete/{id}")
    public String deleteCustomerById(@PathVariable Integer id) {
        return customerServices.deleteCustomerById(id);
    }

    @PutMapping("/update/{id}")
    public String updateCustomerById(@PathVariable Integer id, @RequestBody Customer customerData) {
        return customerServices.updateCustomerById(id,customerData);
    }

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customerData) {
        return customerServices.addCustomer(customerData);
    }
}
