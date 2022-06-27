package com.customer.customer.controller;

import com.customer.customer.entity.Customer;
import com.customer.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/showCustomerDetails")
    public List<Customer> showCustomerDetails() {
        return customerService.getCustomer();
    }

    @PostMapping("/insertCustomerDetails")
    public void insertCustomerDetails(@RequestBody Customer customer) {
        customerService.insertDataInCustomerTable(customer);
    }

    @PutMapping(path = "{id}")
    public void updateCustomerDetails(@PathVariable("id") long id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        customerService.updateDataIncustomerTable(id, firstName, lastName);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCustomerDeatils(@PathVariable("id") long id) {
        customerService.deleteCustomerDetails(id);
    }
}
