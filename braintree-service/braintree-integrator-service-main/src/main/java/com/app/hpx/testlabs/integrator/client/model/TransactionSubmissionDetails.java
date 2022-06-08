package com.app.hpx.testlabs.integrator.client.model;

import java.math.BigDecimal;

public class TransactionSubmissionDetails {

    private boolean settlementFlag;

    private String orderId;
    private String customerId;
    private String paymentMethod;

    private BigDecimal amount;

    public boolean isSettlementFlag() {
        return settlementFlag;
    }

    public void setSettlementFlag(boolean settlementFlag) {
        this.settlementFlag = settlementFlag;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentTransactionDetails{" + "settlementFlag=" + settlementFlag + ", orderId='" + orderId + '\''
                   + ", customerId='" + customerId + '\'' + ", paymentMethod='" + paymentMethod + '\'' + ", amount="
                   + amount + '}';
    }
}
