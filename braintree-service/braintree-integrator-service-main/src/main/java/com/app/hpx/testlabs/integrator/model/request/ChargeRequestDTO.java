package com.app.hpx.testlabs.integrator.model.request;

import java.math.BigDecimal;

public class ChargeRequestDTO {

    private boolean settlementFlag;

    private String orderId;

    private String customerId;

    private String paymentMethod;

    private String paymentNonce;

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

    public String getPaymentNonce() {
        return paymentNonce;
    }

    public void setPaymentNonce(String paymentNonce) {
        this.paymentNonce = paymentNonce;
    }

    @Override
    public String toString() {
        return "ChargeRequestDTO{" + "settlementFlag=" + settlementFlag + ", orderId='" + orderId + '\''
                   + ", customerId='" + customerId + '\'' + ", paymentMethod='" + paymentMethod + '\''
                   + ", paymentNonce='" + paymentNonce + '\'' + ", amount=" + amount + '}';
    }
}
