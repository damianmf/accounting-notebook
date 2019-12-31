package com.accounting.model.account;

import java.math.BigDecimal;

public class Account {

    private BigDecimal value;

    public Account(BigDecimal value) {
        this.value = value;
    }


    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
