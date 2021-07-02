package com.tut.completablefuturedemo.service;

import com.tut.completablefuturedemo.Model.Customer;

public interface CustomerService {
    Customer getCustomer() throws InterruptedException;
}
