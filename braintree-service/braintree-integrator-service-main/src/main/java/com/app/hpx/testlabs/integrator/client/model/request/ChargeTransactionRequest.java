package com.app.hpx.testlabs.integrator.client.model.request;

import com.app.hpx.testlabs.integrator.client.model.TransactionSubmissionDetails;

public class ChargeTransactionRequest {

    private TransactionSubmissionDetails transactionSubmissionDetails;

    public TransactionSubmissionDetails getPaymentTransactionDetails() {
        return transactionSubmissionDetails;
    }

    public void setPaymentTransactionDetails(TransactionSubmissionDetails transactionSubmissionDetails) {
        this.transactionSubmissionDetails = transactionSubmissionDetails;
    }
}
