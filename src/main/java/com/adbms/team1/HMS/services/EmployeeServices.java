package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> getAllEmployees();

    List<Employee> getEmployeeById(Integer id);

    String deleteEmployeeById(Integer id);

    String updateEmployeeById(Integer id, Employee employeeData);

    String addEmployee(Employee employeeData);
}
