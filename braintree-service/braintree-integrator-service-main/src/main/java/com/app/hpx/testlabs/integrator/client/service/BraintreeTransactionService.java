package com.app.hpx.testlabs.integrator.client.service;

import com.app.hpx.testlabs.integrator.client.model.request.ChargeTransactionRequest;
import com.app.hpx.testlabs.integrator.model.response.ChargeResponseDTO;

public interface BraintreeTransactionService {

    ChargeResponseDTO chargeTransaction(ChargeTransactionRequest chargeRequest);

    void refundTransaction();

    void voidTransaction();

    void captureTransaction();

    void captureTransactions();

}
