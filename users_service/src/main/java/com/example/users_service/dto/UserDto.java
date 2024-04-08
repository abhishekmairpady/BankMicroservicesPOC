package com.example.users_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserDto {

    int userId;
    int clientId;


    @NotNull(message = "{customer.name.absent}")
    @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{customer.name.invalid}")
    String userName;

    String fName;

    String lName;

    @Email(message = "{customer.emailid.invalid}")
    @NotNull(message = "{customer.emailid.absent}")
    String email;

    long phone;

    String role;

    String password;

    public UserDto() {

    }

    public UserDto(int userId, int clientId, String userName, String fName, String lName, String email, long phone, String role,String password ) {
        this.userId = userId;
        this.clientId = clientId;
        this.userName = userName;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password=password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
