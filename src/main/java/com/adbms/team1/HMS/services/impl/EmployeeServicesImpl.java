package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.Employee;
import com.adbms.team1.HMS.repositories.EmployeeRepository;
import com.adbms.team1.HMS.repositories.Summary;
import com.adbms.team1.HMS.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public List<Employee> getEmployeeById(Integer id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public String deleteEmployeeById(Integer id) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("deleteEmployeeById").setParameter("emp_id",id).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }

    @Override
    public String updateEmployeeById(Integer id, Employee employeeData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("updateEmployeeById").setParameter("emp_id",id).setParameter("name",employeeData.getEmpName()).setParameter("phone",employeeData.getPhone()).setParameter("email",employeeData.getEmail()).setParameter("type",employeeData.getType()).setParameter("password",employeeData.getPassword()).setParameter("profile",employeeData.getProfilePic()).execute();
        if (!status) {
            msg = "Updated";
        }
        else {
            msg = "Error";
        }
        return msg;
    }

    @Override
    public String addEmployee(Employee employeeData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("addEmployee").setParameter("name",employeeData.getEmpName()).setParameter("phone",employeeData.getPhone()).setParameter("email",employeeData.getEmail()).setParameter("type",employeeData.getType()).setParameter("password",employeeData.getPassword()).setParameter("profile",employeeData.getProfilePic()).execute();
        if (!status) {
            msg = "Added";
        }
        else {
            msg = "Error";
        }
        return msg;
    }

    @Override
    public String employeeLogin(String email, String password) {
        return employeeRepository.employeeLogin(email, password);
    }

    @Override
    public String getSummary() {
        return employeeRepository.getSummary();
    }
}
