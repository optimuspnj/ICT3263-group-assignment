package com.adbms.team1.HMS.repositories;

import com.adbms.team1.HMS.Model.Customer;
import com.adbms.team1.HMS.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value="call hoteldb.getAllEmployees();", nativeQuery=true)
    List<Employee> getAllEmployees();

    @Query(value="call hoteldb.getEmployeeById(:id);", nativeQuery=true)
    List<Employee> getEmployeeById(Integer id);

    @Query(value = "select loginValidator(:email, :password)", nativeQuery = true)
    String employeeLogin(String email, String password);
}
