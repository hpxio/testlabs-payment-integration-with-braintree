package com.app.hpx.testlabs.integrator.model.response;

import com.app.hpx.testlabs.integrator.model.TransactionDetailsModel;

public class ChargeResponseDTO {

    private TransactionDetailsModel transactionDetailsModel;

    public TransactionDetailsModel getTransactionAuthorizationDetails() {
        return transactionDetailsModel;
    }

    public void setTransactionAuthorizationDetails(TransactionDetailsModel transactionDetailsModel) {
        this.transactionDetailsModel = transactionDetailsModel;
    }

    @Override
    public String toString() {
        return "ChargeResponseDTO{" + "transactionAuthorizationDetails=" + transactionDetailsModel + '}';
    }
}
