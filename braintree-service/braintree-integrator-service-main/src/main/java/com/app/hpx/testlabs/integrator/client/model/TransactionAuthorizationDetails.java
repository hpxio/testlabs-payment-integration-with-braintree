package com.app.hpx.testlabs.integrator.client.model;

import com.braintreegateway.Transaction;

public class TransactionAuthorizationDetails {

    private String transactionId;
    private String orderId;

    private String transactionStatus;

    private String networkTransactionId;
    private String authorizedTransactionId;
    private String processorResponseText;
    private String processorResponseCode;

    private String paymentInstrumentType;

    private String createdTimestamp;
    private String updatedTimestamp;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getNetworkTransactionId() {
        return networkTransactionId;
    }

    public void setNetworkTransactionId(String networkTransactionId) {
        this.networkTransactionId = networkTransactionId;
    }

    public String getAuthorizedTransactionId() {
        return authorizedTransactionId;
    }

    public void setAuthorizedTransactionId(String authorizedTransactionId) {
        this.authorizedTransactionId = authorizedTransactionId;
    }

    public String getProcessorResponseText() {
        return processorResponseText;
    }

    public void setProcessorResponseText(String processorResponseText) {
        this.processorResponseText = processorResponseText;
    }

    public String getProcessorResponseCode() {
        return processorResponseCode;
    }

    public void setProcessorResponseCode(String processorResponseCode) {
        this.processorResponseCode = processorResponseCode;
    }

    public String getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

    public void setPaymentInstrumentType(String paymentInstrumentType) {
        this.paymentInstrumentType = paymentInstrumentType;
    }

    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(String createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(String updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Override
    public String toString() {
        return "TransactionAuthorizationDetails{" + "transactionId='" + transactionId + '\'' + ", orderId='" + orderId
                   + '\'' + ", transactionStatus=" + transactionStatus + ", networkTransactionId='"
                   + networkTransactionId + '\'' + ", authorizedTransactionId='" + authorizedTransactionId + '\''
                   + ", processorResponseText='" + processorResponseText + '\'' + ", processorResponseCode='"
                   + processorResponseCode + '\'' + ", paymentInstrumentType=" + paymentInstrumentType
                   + ", createdTimestamp='" + createdTimestamp + '\'' + ", updatedTimestamp='" + updatedTimestamp + '\''
                   + '}';
    }
}
