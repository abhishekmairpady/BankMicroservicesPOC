package com.example.enroll_service.service;

import com.example.enroll_service.Feign.AccountServiceInterface;
import com.example.enroll_service.dao.EnrollDao;
import com.example.enroll_service.dto.AccountDto;
import com.example.enroll_service.dto.EnrollDto;
import com.example.enroll_service.dto.EnrollResponse;
import com.example.enroll_service.model.Account;
import com.example.enroll_service.model.Enroll;
import com.example.enroll_service.model.Notification;
import com.example.enroll_service.model.User;
import com.example.enroll_service.response.AccountServiceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class EnrollServiceService {
    List<Enroll> enrollList= Arrays.asList(new Enroll(1,"Us","sb0","NA","Yes",123456));

    @Autowired
    EnrollDao enrollDao;

    @Autowired
    private RestTemplate template;

    @Autowired
    AccountServiceInterface accountServiceInterface;

    @Autowired
    KafkaPublisher kafkaPublisher;

    String users_service= "http://USERS-SERVICE/userService/addUsers";
    String users_service_get_user= "http://USERS-SERVICE/userService/getClientAndUserDetails/";

    public EnrollResponse addEnrollDetails(EnrollDto enrollDetails) {
        List<User> userList = enrollDetails.getUserList();
        List<User> addedUserList = new ArrayList<>();
        EnrollResponse response= new EnrollResponse();
        Enroll enrollClient = new Enroll();
        enrollClient.setClientType(enrollDetails.getClientType());
        enrollClient.setAffiliationType(enrollDetails.getAffiliationType());
        enrollClient.setIsDualAdmin(enrollDetails.getIsDualAdmin());
        enrollClient.setTaxNo(enrollDetails.getTaxNo());
        enrollClient.setServiceType(enrollDetails.getServiceType());
        enrollClient=enrollDao.save(enrollClient);
        Notification notification=
                new Notification("ADD","Client Enrolled Successfully with client id:"+enrollClient.getClientId(),
                        "abc@gamil.com",9873553,enrollClient.getClientId());

        kafkaPublisher.sendNotificationToTopic(notification);

        Enroll finalEnrollClient = enrollClient;
        userList.forEach(x-> {
            x.setClientId(finalEnrollClient.getClientId());
            addedUserList.add(x);
        });
//        template.postForObject("http://localhost:8081/userService/addUser", userList, User.class);

        List  userResponse= template.postForObject(users_service, addedUserList, List.class);

        Notification notification1=
                new Notification("ADD","User Enrolled Successfully with client id:"+enrollClient.getClientId(),
                        "abc@gamil.com",9873553,enrollClient.getClientId());

        kafkaPublisher.sendNotificationToTopic(notification1);

        response.setEnrollDetails(enrollClient);
        response.setUserList(userResponse);
        return response;
    }

    public List<Enroll> getEnrollDetails() {
        List<Enroll> allEnrollDetails= new ArrayList<>();
        enrollDao.findAll().forEach(allEnrollDetails::add);
        return allEnrollDetails;
    }

    public Enroll getEnrollDetailById(int enrollId) {
        return enrollDao.findById(enrollId).get();
    }

    public void deleteEnrollDetail(int enrollId) {
        enrollDao.deleteById(enrollId);
    }

    public AccountServiceResponse addAccount(AccountDto account) {
        AccountServiceResponse response= new AccountServiceResponse();
        Enroll clientDetails= getEnrollDetailById(account.getClientId());
        Account addedAccount=  accountServiceInterface.addAccount(account).getBody();

        Notification notification=
                new Notification("ADD","Account Added Successfully with client id:"+clientDetails.getClientId(),
                        "abc@gamil.com",9873553,clientDetails.getClientId());

        kafkaPublisher.sendNotificationToTopic(notification);

        response.setEnroll(clientDetails);
        response.setAccountList(Arrays.asList(addedAccount));
        return response;
    }

    public AccountServiceResponse getClientAndUserDetails(int enrollId) {
        AccountServiceResponse response= new AccountServiceResponse();
        Enroll clientDetails= getEnrollDetailById(enrollId);
        users_service_get_user= users_service_get_user +  enrollId;

//        String token = "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1bmFtZTg3IiwiaWF0IjoxNzEyMTU3NTk3LCJleHAiOjE3MTIxNzU1OTd9.NlSP6-vQysw7KyaXtAlQjIXjGhnZRZtVTe9rHQmN1aw";
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", token);
//        HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);

        List  userResponse= template.getForObject(users_service_get_user, List.class);

        response.setEnroll(clientDetails);
        response.setAccountList(userResponse);

        return response;
    }
}
