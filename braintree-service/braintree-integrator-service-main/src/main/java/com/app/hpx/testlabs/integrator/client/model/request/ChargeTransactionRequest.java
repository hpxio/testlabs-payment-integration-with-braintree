package com.app.hpx.testlabs.integrator.client.model.request;

import com.braintreegateway.TransactionRequest;

public class ChargeTransactionRequest {

    private TransactionRequest transactionRequest;

    public TransactionRequest getTransactionRequest() {
        return transactionRequest;
    }

    public void setTransactionRequest(TransactionRequest transactionRequest) {
        this.transactionRequest = transactionRequest;
    }

    @Override
    public String toString() {
        return "ChargeTransactionRequest{" + "transactionRequest=" + transactionRequest + '}';
    }
}
