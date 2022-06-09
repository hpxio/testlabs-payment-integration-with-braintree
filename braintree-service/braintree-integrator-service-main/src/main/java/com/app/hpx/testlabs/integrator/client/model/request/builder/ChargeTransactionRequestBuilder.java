package com.app.hpx.testlabs.integrator.client.model.request.builder;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.braintreegateway.TransactionRequest;

import com.app.hpx.testlabs.integrator.client.model.request.ChargeTransactionRequest;
import com.app.hpx.testlabs.integrator.model.request.ChargeRequestDTO;

@Component
public class ChargeTransactionRequestBuilder implements
    BraintreeServiceRequestBuilder<ChargeRequestDTO, ChargeTransactionRequest> {

    @Override
    public ChargeTransactionRequest build(ChargeRequestDTO request) {
        ChargeTransactionRequest chargeTransactionRequest = new ChargeTransactionRequest();

        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.amount(request.getAmount());
        transactionRequest.orderId(request.getOrderId());
        transactionRequest.customerId(request.getCustomerId());

        transactionRequest.options().submitForSettlement(request.isSettlementFlag());

        /* use PaymentNonce for non-SCB users else use PaymentToken */
        if(Objects.isNull(request.getPaymentMethod())) {
            transactionRequest.paymentMethodNonce(request.getPaymentNonce());
        } else {
            transactionRequest.paymentMethodToken(request.getPaymentMethod());
        }

        chargeTransactionRequest.setTransactionRequest(transactionRequest);
        return chargeTransactionRequest;
    }
}
