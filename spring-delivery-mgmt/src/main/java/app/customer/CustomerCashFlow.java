package app.customer;

import app.enums.PaymentStatus;

import java.math.BigDecimal;

public class CustomerCashFlow {
    String name;

    BigDecimal totalAmount;

    PaymentStatus paymentStatus;

    public CustomerCashFlow(String name, BigDecimal totalAmount, PaymentStatus paymentStatus) {
        this.name = name;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
