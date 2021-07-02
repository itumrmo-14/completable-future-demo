package com.tut.completablefuturedemo.service;

import com.tut.completablefuturedemo.Model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompletableFutureBankService {
    @Autowired
    private CustomerService[] customerServices;

    private List<CompletableFuture<Customer>> futuresList;

    @PostConstruct
    public void init() throws InterruptedException {
        futuresList = new ArrayList<>();

    }

    public List<Customer> getCustomers(){
        try {
            return getCompletableCustomerList().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private CompletableFuture<List<Customer>> getCompletableCustomerList(){
        for(CustomerService customerService : customerServices){
            CompletableFuture<Customer> customerCompletableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    return (customerService.getCustomer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            });
            futuresList.add(customerCompletableFuture);
        }
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[0]));
        CompletableFuture<List<Customer>> allCompletableFuture = allFutures.thenApply(future -> futuresList.stream().map(CompletableFuture::join).collect(Collectors.toList()));
        return allCompletableFuture.toCompletableFuture();
    }
}
