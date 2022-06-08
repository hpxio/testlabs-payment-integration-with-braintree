package com.app.hpx.testlabs.integrator.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.client.config.BraintreeGatewayConfig;
import com.app.hpx.testlabs.integrator.client.model.request.ChargeTransactionRequest;
import com.app.hpx.testlabs.integrator.client.model.response.TransactionAuthorizationResponse;
import com.app.hpx.testlabs.integrator.client.model.response.builder.BraintreeServiceResponseBuilder;
import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;

@Component
public class BraintreeTransactionServiceImpl implements BraintreeTransactionService{

    private static final Logger LOG = LoggerFactory.getLogger(BraintreeTransactionServiceImpl.class);

    private final BraintreeGatewayConfig gatewayConfig;

    private final BraintreeServiceResponseBuilder<Transaction, TransactionAuthorizationResponse> responseBuilder;

    @Autowired
    public BraintreeTransactionServiceImpl(
        BraintreeGatewayConfig gatewayConfig,
        BraintreeServiceResponseBuilder<Transaction, TransactionAuthorizationResponse> responseBuilder
    ) {
        this.gatewayConfig = gatewayConfig;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public TransactionAuthorizationResponse chargeTransaction(ChargeTransactionRequest chargeRequest) {
        BraintreeGateway gatewayInstance = gatewayConfig.getBraintreeGatewayInstance();

        TransactionRequest transactionRequest = generateTransactionRequest(chargeRequest);
        Result<Transaction> chargeTransactionResult = gatewayInstance.transaction().sale(transactionRequest);

        if(chargeTransactionResult.isSuccess()){
            return responseBuilder.build(chargeTransactionResult.getTransaction());
        } else {
            /* TODO : throw charge application exception here */
            throw new RuntimeException("Error occurred while charging transaction!");
        }
    }

    @Override
    public void refundTransaction() {

    }

    @Override
    public void voidTransaction() {

    }

    @Override
    public void captureTransaction() {

    }

    @Override
    public void captureTransactions() {

    }

    private TransactionRequest generateTransactionRequest(ChargeTransactionRequest chargeRequest) {
        TransactionRequest transactionRequest = new TransactionRequest();

        transactionRequest.amount(chargeRequest.getPaymentTransactionDetails().getAmount());
        transactionRequest.orderId(chargeRequest.getPaymentTransactionDetails().getOrderId());

        transactionRequest.customerId(chargeRequest.getPaymentTransactionDetails().getCustomerId());

        transactionRequest.paymentMethodToken(chargeRequest.getPaymentTransactionDetails().getPaymentMethod());
        transactionRequest.options().submitForSettlement(chargeRequest.getPaymentTransactionDetails().isSettlementFlag());

        return transactionRequest;
    }
}
