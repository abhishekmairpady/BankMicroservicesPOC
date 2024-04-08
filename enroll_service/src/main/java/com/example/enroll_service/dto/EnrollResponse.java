package com.example.enroll_service.dto;

import com.example.enroll_service.model.Enroll;
import com.example.enroll_service.model.User;

import java.util.List;

public class EnrollResponse {
    Enroll enrollDetails;
    List<User> userList;

    public EnrollResponse() {
    }

    public EnrollResponse(Enroll enrollDetails, List<User> userList) {
        this.enrollDetails = enrollDetails;
        this.userList = userList;
    }

    public Enroll getEnrollDetails() {
        return enrollDetails;
    }

    public void setEnrollDetails(Enroll enrollDetails) {
        this.enrollDetails = enrollDetails;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
