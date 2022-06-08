package com.app.hpx.testlabs.integrator.client.model.response;

import com.app.hpx.testlabs.integrator.client.model.TransactionAuthorizationDetails;

public class TransactionAuthorizationResponse {

    private TransactionAuthorizationDetails transactionAuthorizationDetails;

    public TransactionAuthorizationDetails getTransactionAuthorizationDetails() {
        return transactionAuthorizationDetails;
    }

    public void setTransactionAuthorizationDetails(TransactionAuthorizationDetails transactionAuthorizationDetails) {
        this.transactionAuthorizationDetails = transactionAuthorizationDetails;
    }
}
