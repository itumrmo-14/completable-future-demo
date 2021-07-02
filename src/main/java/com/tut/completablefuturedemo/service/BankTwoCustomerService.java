package com.tut.completablefuturedemo.service;

import com.tut.completablefuturedemo.Model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BankTwoCustomerService implements CustomerService{
    @Override
    public Customer getCustomer() throws InterruptedException {
        log.info("Preparing to get bank two customer");
        Thread.sleep(2000);
        log.info(Thread.currentThread().getName());
        Customer customer = Customer.builder().firstname("Bank Two John").lastname("Bank Two Doe").build();
        return customer;
    }
}
