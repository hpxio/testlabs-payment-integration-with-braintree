package com.app.hpx.testlabs.integrator.model.response;

public class ChargeResponseDTO {

    private TransactionAuthorizationDetails transactionAuthorizationDetails;

    public TransactionAuthorizationDetails getTransactionAuthorizationDetails() {
        return transactionAuthorizationDetails;
    }

    public void setTransactionAuthorizationDetails(TransactionAuthorizationDetails transactionAuthorizationDetails) {
        this.transactionAuthorizationDetails = transactionAuthorizationDetails;
    }

    @Override
    public String toString() {
        return "ChargeResponseDTO{" + "transactionAuthorizationDetails=" + transactionAuthorizationDetails + '}';
    }
}
