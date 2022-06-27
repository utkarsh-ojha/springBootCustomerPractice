package com.customer.customer.service;

import com.customer.customer.entity.Customer;
import com.customer.customer.repository.CustomerReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private CustomerReposotory customerReposotory;

    @Autowired
    public CustomerService(CustomerReposotory customerReposotory) {
        this.customerReposotory = customerReposotory;
    }

    public void insertDataInCustomerTable(Customer customer) {
        customerReposotory.save(customer);
    }

    public List<Customer> getCustomer() {
        return customerReposotory.findAll();
    }

    @Transactional
    public void updateDataIncustomerTable(long id, String firstName, String lastName) {

        Customer customer = customerReposotory.findById(id)
                .orElseThrow(() -> new IllegalStateException("No customer found with this ID"));


        if (firstName != null && firstName.length()>0 && !Objects.equals(customer.getFirstName(),firstName)){
            customer.setFirstName(firstName);
        }

        if (lastName != null && lastName.length()>0 && !Objects.equals(customer.getLastName(),lastName)){
            customer.setLastName(lastName);
        }
        customerReposotory.save(customer);
    }

    public void deleteCustomerDetails(long id){
        customerReposotory.deleteById(id);
    }
}
