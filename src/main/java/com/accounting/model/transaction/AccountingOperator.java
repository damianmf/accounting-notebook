package com.accounting.model.transaction;

import java.math.BigDecimal;

public class AccountingOperator {

    public static BigDecimal calculate(TransactionType type, BigDecimal transactionValue, BigDecimal accountValue) throws Exception {
        if(TransactionType.DEBIT.equals(type))
            return accountValue.add(transactionValue);

        if(TransactionType.CREDIT.equals(type))
            return accountValue.subtract(transactionValue);

        throw new Exception(String.format("Invalid operation type %s", type));
    }
}
