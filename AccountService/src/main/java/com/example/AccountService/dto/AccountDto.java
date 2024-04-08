package com.example.AccountService.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AccountDto {

    int accountId;
    int accountIdentifier;
    int clientId;
    String accType;
    int status;
    long balance;

    public AccountDto() {

    }

    public AccountDto(int accountId, int accountIdentifier, int clientId, String accType, int status, long balance) {
        this.accountId = accountId;
        this.accountIdentifier = accountIdentifier;
        this.clientId = clientId;
        this.accType = accType;
        this.status = status;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(int accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
