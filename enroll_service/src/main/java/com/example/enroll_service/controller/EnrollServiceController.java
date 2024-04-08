package com.example.enroll_service.controller;

import com.example.enroll_service.dto.AccountDto;
import com.example.enroll_service.dto.EnrollDto;
import com.example.enroll_service.dto.EnrollResponse;
import com.example.enroll_service.model.Account;
import com.example.enroll_service.model.Enroll;
import com.example.enroll_service.response.AccountServiceResponse;
import com.example.enroll_service.service.EnrollServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/enroll")
public class EnrollServiceController {

    @Autowired
    EnrollServiceService enrollServiceService;

    @PostMapping("/enrollClient")
    public EnrollResponse addEnrollDetails(@RequestBody EnrollDto enrollDetails){
        return enrollServiceService.addEnrollDetails(enrollDetails);
    }

    @GetMapping("/getEnrollDetails")
    public List<Enroll> getEnrollDetails(){
        return enrollServiceService.getEnrollDetails();
    }

    @GetMapping("/getEnrollDetail/{enrollId}")
    public Enroll getEnrollDetailById(@PathVariable int enrollId){
        return  enrollServiceService.getEnrollDetailById(enrollId);
    }

    @DeleteMapping("/deleteEnrollDetail/{enrollId}")
    public void deleteEnrollDetail(@PathVariable int enrollId){
        enrollServiceService.deleteEnrollDetail(enrollId);
    }

    @PostMapping("/addAccount")
    public ResponseEntity<AccountServiceResponse> addAccount(@RequestBody AccountDto account){
        return new ResponseEntity<>(enrollServiceService.addAccount(account), HttpStatus.OK);
    }

    @GetMapping("/getClientAndUserDetails/{enrollId}")
    public AccountServiceResponse getClientAndUserDetails(@PathVariable int enrollId){
        return  enrollServiceService.getClientAndUserDetails(enrollId);
    }
}
