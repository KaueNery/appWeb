package com.webApp.app.models;

import java.math.BigDecimal;

/**
 * Created by knery on 05/07/17.
 */
public class PaymentData {

    private BigDecimal value;

    public PaymentData(){

    }

    public PaymentData(BigDecimal value) {
        this.value = value;
    }
    public BigDecimal getValue() {
        return value;
    }
}
