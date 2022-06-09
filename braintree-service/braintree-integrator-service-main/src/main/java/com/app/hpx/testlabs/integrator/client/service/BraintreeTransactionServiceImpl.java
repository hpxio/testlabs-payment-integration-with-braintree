package com.app.hpx.testlabs.integrator.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;

import com.app.hpx.testlabs.integrator.client.config.BraintreeGatewayConfig;
import com.app.hpx.testlabs.integrator.client.model.request.ChargeTransactionRequest;
import com.app.hpx.testlabs.integrator.client.model.response.builder.BraintreeServiceResponseBuilder;
import com.app.hpx.testlabs.integrator.model.response.ChargeResponseDTO;

@Component
public class BraintreeTransactionServiceImpl implements BraintreeTransactionService{

    private static final Logger LOG = LoggerFactory.getLogger(BraintreeTransactionServiceImpl.class);

    private final BraintreeGatewayConfig gatewayConfig;

    private final BraintreeServiceResponseBuilder<Transaction, ChargeResponseDTO> responseBuilder;

    @Autowired
    public BraintreeTransactionServiceImpl(BraintreeGatewayConfig gatewayConfig,
        BraintreeServiceResponseBuilder<Transaction, ChargeResponseDTO> responseBuilder) {
        this.gatewayConfig = gatewayConfig;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public ChargeResponseDTO chargeTransaction(ChargeTransactionRequest chargeRequest) {
        BraintreeGateway gatewayInstance = gatewayConfig.getBraintreeGatewayInstance();

        Result<Transaction> chargeTransactionResult =
            gatewayInstance.transaction().sale(chargeRequest.getTransactionRequest());

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
}
