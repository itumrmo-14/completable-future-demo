package com.tut.completablefuturedemo.service;

import com.tut.completablefuturedemo.Model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BankThreeCustomerService implements CustomerService{
    @Override
    public Customer getCustomer() throws InterruptedException {
        log.info("Preparing to get bank three customer");
        Thread.sleep(2000);
        log.info(Thread.currentThread().getName());
        Customer customer = Customer.builder().firstname("Bank Three John").lastname("Bank Three Doe").build();
        return customer;
    }
}
