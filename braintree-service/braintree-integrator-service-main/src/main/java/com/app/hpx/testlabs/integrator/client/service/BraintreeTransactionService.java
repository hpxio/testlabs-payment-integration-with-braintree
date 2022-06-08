package com.app.hpx.testlabs.integrator.client.service;

import com.app.hpx.testlabs.integrator.client.model.request.ChargeTransactionRequest;
import com.app.hpx.testlabs.integrator.client.model.response.TransactionAuthorizationResponse;

interface BraintreeTransactionService {

    TransactionAuthorizationResponse chargeTransaction(ChargeTransactionRequest chargeRequest);

    void refundTransaction();

    void voidTransaction();

    void captureTransaction();

    void captureTransactions();

}
