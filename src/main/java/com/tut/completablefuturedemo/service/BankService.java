package com.tut.completablefuturedemo.service;

import com.tut.completablefuturedemo.Model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BankService {
    @Autowired
    private CustomerService[] customerServices;

    public List<Customer> getCustomers() throws InterruptedException {
        List<Customer> customers = new ArrayList<>();
        for(CustomerService customerService : customerServices){
            customers.add(customerService.getCustomer());
        }
        return customers;
    }
}
