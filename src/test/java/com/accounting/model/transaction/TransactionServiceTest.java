package com.accounting.model.transaction;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class TransactionServiceTest {
    TransactionRepository repository = new TransactionRepository();

    TransactionService service = new TransactionService(repository);

    @Test
    public void test() throws InterruptedException {
        for (int z = 0; z < 1; ++z){
            for (int i = 0; i < 100000; ++i){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            service.create(TransactionDto.newBuilder().withType(TransactionType.DEBIT).withValue(BigDecimal.TEN).build());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            Thread.sleep(1000);
            System.out.println(repository.getValueAccount());
        }
    }
}