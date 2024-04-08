package com.example.enroll_service.response;

import com.example.enroll_service.model.Account;
import com.example.enroll_service.model.Enroll;

import java.util.List;

public class AccountServiceResponse {
    Enroll enroll;
    List<Account> accountList;

    public AccountServiceResponse() {
    }

    public AccountServiceResponse(Enroll enroll, List<Account> accountList) {
        this.enroll = enroll;
        this.accountList = accountList;
    }

    public Enroll getEnroll() {
        return enroll;
    }

    public void setEnroll(Enroll enroll) {
        this.enroll = enroll;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
