package com.app.hpx.testlabs.integrator.client.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hpx.testlabs.integrator.client.config.BraintreeGatewayInstance;
import com.app.hpx.testlabs.integrator.client.model.request.CreateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.exception.IntegratorErrorCodes;
import com.app.hpx.testlabs.integrator.exception.util.IntegratorExceptionUtil;
import com.braintreegateway.Customer;
import com.braintreegateway.Result;

@Service
public class BraintreeCustomerServiceImpl implements BraintreeCustomerService {

	private final BraintreeGatewayInstance gateway;

	@Autowired
	public BraintreeCustomerServiceImpl(BraintreeGatewayInstance gateway) {
		this.gateway = gateway;
	}

	@Override
	public String createCustomer(CreateBraintreeCustomerRequest request) {
		String customerId = null;
		Result<Customer> createCustomerResult = gateway.getBraintreeGatewayInstance()
				.customer().create(request.getCustomerRequest());

		if (createCustomerResult.isSuccess()) {
			customerId = createCustomerResult.getTarget().getId();
		} else {
			throw IntegratorExceptionUtil.buildException(IntegratorErrorCodes.CUSTOMER_NOT_CREATED);
		}
		return customerId;
	}
}