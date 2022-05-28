package com.app.hpx.testlabs.integrator.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.braintreegateway.BraintreeGateway;

@Configuration
public class BraintreeGatewayConfig {

    private static final Logger LOG = LoggerFactory.getLogger(BraintreeGatewayConfig.class);

    private final BraintreeGatewayProperties braintreeGatewayProperties;

		@Autowired
    public BraintreeGatewayConfig(BraintreeGatewayProperties braintreeGatewayProperties) {
        this.braintreeGatewayProperties = braintreeGatewayProperties;
    }

    public BraintreeGateway getBraintreeGatewayInstance() {
        BraintreeGateway braintreeGateway =
            new BraintreeGateway(braintreeGatewayProperties.getEnvironment(),
                braintreeGatewayProperties.getMerchantId(),
                braintreeGatewayProperties.getPublicKey(),
                braintreeGatewayProperties.getPrivateKey());

        LOG.info("Braintree Gateway Instance : {}", braintreeGateway);
        return braintreeGateway;
    }
}
