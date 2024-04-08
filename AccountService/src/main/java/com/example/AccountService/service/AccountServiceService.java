package com.example.AccountService.service;

import com.example.AccountService.dto.AccountDto;
import com.example.AccountService.exception.SVBException;
import com.example.AccountService.mapper.AccountMapper;
import com.example.AccountService.model.Account;
import com.example.AccountService.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceService {

    @Autowired
    AccountRepository accountRepository;

    public Account addAccount(AccountDto account) {
        Account userEntity= AccountMapper.MAPPER.covertToEntity(account);
        return  accountRepository.save(userEntity);
    }

    public List<Account> getAccounts() throws SVBException {
        List<Account> allAccounts= new ArrayList<>();
        accountRepository.findAll().forEach(allAccounts::add);
        return allAccounts;
    }

    public Account getAccount(int userId) throws SVBException {
        Optional<Account> optional = accountRepository.findById(userId);
        Account account= optional.orElseThrow(() -> new SVBException("Service.USER_NOT_FOUND"));
        return account;
    }

    public void deleteAccount(int accountId) {
        accountRepository.deleteById(accountId);
    }
}
