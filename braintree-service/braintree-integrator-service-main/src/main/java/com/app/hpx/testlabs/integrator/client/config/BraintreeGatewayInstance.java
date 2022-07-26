package com.app.hpx.testlabs.integrator.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.braintreegateway.BraintreeGateway;

@Component
public class BraintreeGatewayInstance {
	private final BraintreeApiGatewayConfig config;

	@Autowired
	public BraintreeGatewayInstance(BraintreeApiGatewayConfig config) {
		this.config = config;
	}

	public BraintreeGateway getBraintreeGatewayInstance() {
		return new BraintreeGateway(config.getEnvironment(), config.getMerchantId(),
				config.getPublicKey(), config.getPrivateKey());
	}
}