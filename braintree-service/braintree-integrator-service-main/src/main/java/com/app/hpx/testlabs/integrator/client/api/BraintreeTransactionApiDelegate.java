package com.app.hpx.testlabs.integrator.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.client.model.request.ChargeTransactionRequest;
import com.app.hpx.testlabs.integrator.client.service.BraintreeTransactionService;
import com.app.hpx.testlabs.integrator.model.response.ChargeResponseDTO;

@Component
public class BraintreeTransactionApiDelegate {

    private final BraintreeTransactionService transactionService;

    @Autowired
    public BraintreeTransactionApiDelegate(BraintreeTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public ChargeResponseDTO chargeTransactionDelegate(ChargeTransactionRequest request) {
        return transactionService.chargeTransaction(request);
    }


    public void refundTransactionDelegate() {

    }


    public void voidTransactionDelegate() {

    }


    public void captureTransactionDelegate() {

    }


    public void captureTransactionsDelegate() {

    }
}
