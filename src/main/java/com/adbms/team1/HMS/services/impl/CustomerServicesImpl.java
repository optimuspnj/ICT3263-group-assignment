package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.Customer;
import com.adbms.team1.HMS.Model.FoodOrder;
import com.adbms.team1.HMS.repositories.CustomerRepository;
import com.adbms.team1.HMS.repositories.FoodOrderRepository;
import com.adbms.team1.HMS.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllFoodOrder();
    }

    @Override
    public List<Customer> getCustomerById(Integer id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public String deleteCustomerById(Integer id) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("deleteCustomerById").setParameter("cus_id",id).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }

    @Override
    public String updateCustomerById(Integer id, Customer customerData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("updateCustomerById").setParameter("cus_id",id).setParameter("name",customerData.getCusName()).setParameter("email",customerData.getEmail()).setParameter("address",customerData.getAddress()).setParameter("nic",customerData.getNic()).setParameter("phone",customerData.getPhone()).setParameter("password",customerData.getPassword()).setParameter("profile",customerData.getProfilePic()).execute();
        if (!status) {
            msg = "Updated";
        }
        else {
            msg = "Error";
        }
        return msg;
    }

    @Override
    public String addCustomer(Customer customerData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("addCustomer").setParameter("name",customerData.getCusName()).setParameter("email",customerData.getEmail()).setParameter("address",customerData.getAddress()).setParameter("nic",customerData.getNic()).setParameter("phone",customerData.getPhone()).setParameter("password",customerData.getPassword()).setParameter("profile",customerData.getProfilePic()).execute();
        if (!status) {
            msg = "Added";
        }
        else {
            msg = "Error";
        }
        return msg;
    }
}
