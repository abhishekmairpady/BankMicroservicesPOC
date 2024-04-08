package com.example.AccountService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long seqId;
    long accountIdentifier;
    int clientId;
    String accType;
    int status;
    long balance;


    public Account() {
    }

    public Account(long seqId, long accountIdentifier, int clientId, String accType, int status, long balance) {
        this.seqId = seqId;
        this.accountIdentifier = accountIdentifier;
        this.clientId = clientId;
        this.accType = accType;
        this.status = status;
        this.balance = balance;
    }

    public long getSeqId() {
        return seqId;
    }

    public void setSeqId(long seqId) {
        this.seqId = seqId;
    }

    public long getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(long accountIdentifier) {
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

    @Override
    public String toString() {
        return "Account{" +
                "seqId=" + seqId +
                ", accountIdentifier=" + accountIdentifier +
                ", clientId=" + clientId +
                ", accType='" + accType + '\'' +
                ", status=" + status +
                ", balance=" + balance +
                '}';
    }
}
