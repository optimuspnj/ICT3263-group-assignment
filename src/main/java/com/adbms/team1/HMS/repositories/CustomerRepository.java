package com.adbms.team1.HMS.repositories;

import com.adbms.team1.HMS.Model.Customer;
import com.adbms.team1.HMS.Model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="call hoteldb.getAllCustomers();", nativeQuery=true)
    List<Customer> getAllFoodOrder();

    @Query(value="call hoteldb.getCustomerById(:id);", nativeQuery=true)
    List<Customer> getCustomerById(Integer id);
}
