package com.accounting.model.account;

import com.accounting.model.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final TransactionRepository repository;

    @Autowired
    public AccountService(TransactionRepository repository) {
        this.repository = repository;
    }

    public BigDecimal findStatusAccount() {
        return this.repository.getValueAccount();

    }

}
