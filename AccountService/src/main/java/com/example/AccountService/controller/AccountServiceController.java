package com.example.AccountService.controller;

import com.example.AccountService.dto.AccountDto;
import com.example.AccountService.exception.SVBException;
import com.example.AccountService.model.Account;
import com.example.AccountService.service.AccountServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AccountServiceController {

    @Autowired
    AccountServiceService accountServiceService;

    @PostMapping("/addAccount")
    public ResponseEntity<Account> addAccount(@RequestBody AccountDto account){
        return new ResponseEntity<>(accountServiceService.addAccount(account),HttpStatus.OK);
    }

    @GetMapping("/getAccounts")
    public ResponseEntity<List<Account>> getAccounts() throws SVBException {
        return new ResponseEntity<>(accountServiceService.getAccounts(), HttpStatus.OK);
    }

    @GetMapping("/getAccount/{accountId}")
    public ResponseEntity<Account> getUser(@PathVariable int accountId) throws SVBException {
        return new ResponseEntity<>(accountServiceService.getAccount(accountId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteAccount/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accountId){
        accountServiceService.deleteAccount(accountId);
        return new ResponseEntity<>("Deleted Users ",HttpStatus.OK);
    }

}
