package com.accounting.model.transaction;

import com.accounting.exceptions.ValidationException;
import com.accounting.model.account.Account;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

@Repository
public class TransactionRepository {

    private ConcurrentHashMap<UUID, Transaction> transactionMap;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Account account;

    public TransactionRepository() {
        this.account = new Account(BigDecimal.ZERO);
        this.transactionMap = new ConcurrentHashMap();
    }

    public List<Transaction> findAll() {
        lock.readLock().lock();
        List<Transaction> collect = Lists.newArrayList();
        try {
            collect = transactionMap.values().stream().sorted(Transaction::compareTo).collect(Collectors.toList());
        }finally {
            lock.readLock().unlock();
        }
        return collect;
    }

    public Optional<Transaction> find(String id) {
        lock.readLock().lock();
        Optional<Transaction> transaction;
        try {
            transaction = Optional.ofNullable(transactionMap.get(UUID.fromString(id)));
        }finally {
            lock.readLock().unlock();
        }
        return transaction;
    }

    public Transaction save(Transaction transaction) throws Exception {
        lock.writeLock().lock();
        try {
            TransactionValidator.validateAccountStatus(transaction, account);

            UUID uuid = UUID.randomUUID();
            transaction.setId(uuid);
            transactionMap.put(transaction.getId(), transaction);
            account.setValue(AccountingOperator.calculate(transaction.getType(), transaction.getValue(), account.getValue()));
        }finally {
            lock.writeLock().unlock();
        }
        return transaction;
    }

    public BigDecimal getValueAccount(){
        lock.readLock().lock();
        BigDecimal value;
        try {
            value = this.account.getValue();
        }finally {
            lock.readLock().unlock();
        }
        return value;
    }

}
