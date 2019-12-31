package com.accounting.model.transaction;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class TransactionRepositoryTest {
    TransactionRepository repository = new TransactionRepository();

    @Test
    public void test(){

        for (int i = 0; i < 100; ++i){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        repository.save(Transaction.newBuilder().withType(TransactionType.DEBIT).withValue(BigDecimal.TEN).build());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }

}