package com.accounting.model.transaction;

import com.accounting.exceptions.ValidationErrorCode;
import com.accounting.exceptions.ValidationException;
import com.accounting.model.account.Account;

import java.math.BigDecimal;

public class TransactionValidator {

    public static void validateTransactionInput(TransactionDto transactionDto) throws ValidationException {
        if(transactionDto.getValue() == null || transactionDto.getValue().compareTo(BigDecimal.ZERO) != 1){
            throw new ValidationException(ValidationErrorCode.INVALID_DATA, "Invalid transaction amount");
        }
    }

    public static void validateAccountStatus(Transaction toDomain, Account account) throws ValidationException {
        if(TransactionType.CREDIT.equals(toDomain.getType()) && account.getValue().compareTo(toDomain.getValue()) == -1)
            throw new ValidationException(ValidationErrorCode.NOT_ENOUGH_MONY, "Not enough money");
    }
}
