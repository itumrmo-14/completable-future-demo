package com.tut.completablefuturedemo.controller;

import com.tut.completablefuturedemo.service.BankService;
import com.tut.completablefuturedemo.service.CompletableFutureBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bank-service")
@Slf4j
public class CustomerController {

    @Autowired
    private BankService bankService;
    @Autowired
    private CompletableFutureBankService completableFutureBankService;

    @GetMapping(value = "customer")
    public ResponseEntity getCustomer() throws InterruptedException {
        log.info("Received request to get bank customer");
        return ResponseEntity.ok(bankService.getCustomers());
    }

    @GetMapping(value = "completable-customer")
    public ResponseEntity getCompletableCustomers() throws InterruptedException {
        log.info("Received request to get bank completable customer");
        return ResponseEntity.ok(completableFutureBankService.getCustomers());
    }
}
