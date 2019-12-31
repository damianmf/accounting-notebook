package com.accounting.model.transaction;

import java.time.LocalDateTime;

public class TransactionTranslator {

    public static TransactionDto toDto(Transaction domain){
        return TransactionDto.newBuilder()
                .withDateTime(domain.getDateTime())
                .withType(domain.getType())
                .withValue(domain.getValue())
                .withId(domain.getId().toString())
                .build();
    }

    public static Transaction toDomain(TransactionDto dto){
        return Transaction.newBuilder()
                .withDateTime(LocalDateTime.now())
                .withType(dto.getType())
                .withValue(dto.getValue())
                .build();
    }

    public static TransactionDto toBriefDto(Transaction domain) {
        return TransactionDto.newBuilder()
                .withType(domain.getType())
                .withValue(domain.getValue())
                .withId(domain.getId().toString())
                .build();
    }
}
