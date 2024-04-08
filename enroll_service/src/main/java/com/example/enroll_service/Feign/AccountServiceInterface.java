package com.example.enroll_service.Feign;

import com.example.enroll_service.dto.AccountDto;
import com.example.enroll_service.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("ACCOUNTSERVICE")
public interface AccountServiceInterface {

    @PostMapping("/addAccount")
    public ResponseEntity<Account> addAccount(@RequestBody AccountDto account);

    @GetMapping("/getAccounts")
    public ResponseEntity<List<Account>> getAccounts();
    @GetMapping("/getAccount/{accountId}")
    public ResponseEntity<Account> getUser(@PathVariable int accountId);

    @DeleteMapping("/deleteAccount/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accountId);

}
