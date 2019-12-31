package com.accounting.model.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Transaction implements Comparable<Transaction> {

    private BigDecimal value;
    private TransactionType type;
    private LocalDateTime dateTime;
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(value, that.value) &&
                type == that.type &&
                Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type, dateTime, id);
    }

    private Transaction(Builder builder) {
        value = builder.value;
        type = builder.type;
        dateTime = builder.dateTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Transaction copy) {
        Builder builder = new Builder();
        builder.value = copy.getValue();
        builder.type = copy.getType();
        builder.dateTime = copy.getDateTime();
        return builder;
    }

    @Override
    public int compareTo(Transaction u) {
        if (getDateTime() == null || u.getDateTime() == null) {
            return 0;
        }
        return getDateTime().compareTo(u.getDateTime());
    }


    public static final class Builder {
        private BigDecimal value;
        private TransactionType type;
        private LocalDateTime dateTime;

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

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
