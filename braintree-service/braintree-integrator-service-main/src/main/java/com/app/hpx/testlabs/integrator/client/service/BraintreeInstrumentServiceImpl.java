package com.app.hpx.testlabs.integrator.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.client.config.BraintreeGatewayConfig;
import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Customer;
import com.braintreegateway.PaymentMethod;
import com.braintreegateway.PaymentMethodRequest;
import com.braintreegateway.Result;
import com.braintreegateway.exceptions.NotFoundException;

@Component
public class BraintreeInstrumentServiceImpl implements BraintreeInstrumentService {

    private static final Logger LOG = LoggerFactory.getLogger(BraintreeInstrumentServiceImpl.class);

    private final BraintreeGatewayConfig gatewayConfig;

    @Autowired
    public BraintreeInstrumentServiceImpl(BraintreeGatewayConfig gatewayConfig) {
        this.gatewayConfig = gatewayConfig;
    }

    @Override
    public String addInstrument(String customerId, String paymentNonce) {
        BraintreeGateway gatewayInstance = gatewayConfig.getBraintreeGatewayInstance();

        try {
            gatewayInstance.customer().find(customerId);
        } catch (NotFoundException nfe){
            /* TODO : throw instrument-onboarding application exception here */
            throw new RuntimeException("Customer does not exist!");
        }

        /* create minimal instrument onboarding request */
        PaymentMethodRequest paymentMethodRequest = new PaymentMethodRequest();
        paymentMethodRequest.customerId(customerId);
        paymentMethodRequest.paymentMethodNonce(paymentNonce);

        Result<? extends PaymentMethod> createInstrument =
            gatewayInstance.paymentMethod().create(paymentMethodRequest);

        if (createInstrument.isSuccess()) {
            PaymentMethod resultTarget = createInstrument.getTarget();
            return resultTarget.getToken();
        } else {
            /* TODO : throw instrument-onboarding application exception here */
            throw new RuntimeException("Error occurred during instrument onboarding!");
        }
    }

    @Override
    public boolean deleteInstrument(String paymentToken) {
        BraintreeGateway gatewayInstance = gatewayConfig.getBraintreeGatewayInstance();

        try {
            /* check if the token with given data exists */
            gatewayInstance.paymentMethod().find(paymentToken);

            /* issue delete request for given ID */
            Result<? extends PaymentMethod> deleteInstrumentResult =
                gatewayInstance.paymentMethod().delete(paymentToken);

            return deleteInstrumentResult.isSuccess();
        } catch (NotFoundException nfe) {
            /* TODO : throw token-deletion application exception here */
            throw new RuntimeException("Payment token does not exist");
        } catch (Exception ex) {
            /* TODO : throw token-deletion application exception here */
            throw new RuntimeException("Error occurred while deleting payment instrument!");
        }
    }

    @Override
    public boolean checkIfDefaultInstrument(String paymentToken) {
        BraintreeGateway gatewayInstance = gatewayConfig.getBraintreeGatewayInstance();

        try {
            /* check if the token with given data exists */
            PaymentMethod paymentMethod = gatewayInstance.paymentMethod().find(paymentToken);
            String customerId = paymentMethod.getCustomerId();

            LOG.info("Payment Token exists for Customer : {}", customerId);
            return paymentMethod.isDefault();
        } catch (NotFoundException nfe) {
            /* TODO : throw token-finding application exception here */
            throw new RuntimeException("Payment token does not exist");
        } catch (Exception ex) {
            /* TODO : throw token-finding application exception here */
            throw new RuntimeException("Error occurred while finding payment instrument!");
        }
    }
}
