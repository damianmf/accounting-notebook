package com.accounting.model.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {

    private BigDecimal value;
    private TransactionType type;
    private LocalDateTime dateTime;
    private String id;

    public TransactionDto() {
    }

    public String getId() {
        return id;
    }

    private TransactionDto(Builder builder) {
        value = builder.value;
        type = builder.type;
        dateTime = builder.dateTime;
        id = builder.id;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TransactionDto copy) {
        Builder builder = new Builder();
        builder.value = copy.getValue();
        builder.type = copy.getType();
        builder.dateTime = copy.getDateTime();
        builder.id = copy.getId();
        return builder;
    }

    public BigDecimal getValue() {
        return value;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public static final class Builder {
        private BigDecimal value;
        private TransactionType type;
        private LocalDateTime dateTime;
        private String id;

        private Builder() {
        }

        public Builder withValue(BigDecimal val) {
            value = val;
            return this;
        }

        public Builder withType(TransactionType val) {
            type = val;
            return this;
        }

        public Builder withDateTime(LocalDateTime val) {
            dateTime = val;
            return this;
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public TransactionDto build() {
            return new TransactionDto(this);
        }
    }
}
