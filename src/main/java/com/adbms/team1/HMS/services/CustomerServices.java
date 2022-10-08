package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.Customer;
import com.adbms.team1.HMS.Model.FoodOrder;

import java.util.List;

public interface CustomerServices {
    List<Customer> getAllCustomers();

    List<Customer> getCustomerById(Integer id);

    String deleteCustomerById(Integer id);

    String updateCustomerById(Integer id, Customer customerData);

    String addCustomer(Customer customerData);
}
