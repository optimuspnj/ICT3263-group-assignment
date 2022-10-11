package com.adbms.team1.HMS.controllers;

import com.adbms.team1.HMS.Model.Customer;
import com.adbms.team1.HMS.Model.Employee;
import com.adbms.team1.HMS.Model.LoginDetails;
import com.adbms.team1.HMS.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/all")
    public List<Employee> getAllCustomers() {
        return employeeServices.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public List<Employee> getEmployeeById(@PathVariable Integer id) {
        return employeeServices.getEmployeeById(id);
    }

    @PutMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        return employeeServices.deleteEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public String updateEmployeeById(@PathVariable Integer id, @RequestBody Employee employeeData) {
        return employeeServices.updateEmployeeById(id, employeeData);
    }
    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employeeData) {
        return employeeServices.addEmployee(employeeData);
    }

    @PostMapping("/login")
    public String employeeLogin(@RequestBody LoginDetails loginDetails) {
        return employeeServices.employeeLogin(loginDetails.getEmail(), loginDetails.getPassword());
    }
}
