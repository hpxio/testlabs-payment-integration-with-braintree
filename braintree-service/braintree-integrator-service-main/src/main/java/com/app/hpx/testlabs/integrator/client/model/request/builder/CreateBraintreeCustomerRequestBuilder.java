package com.app.hpx.testlabs.integrator.client.model.request.builder;

import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.client.model.request.CreateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequest;

@Component
public class CreateBraintreeCustomerRequestBuilder implements
		CustomerRequestBuilder<CreateCustomerRequest, CreateBraintreeCustomerRequest> {

	@Override
	public CreateBraintreeCustomerRequest build(CreateCustomerRequest request) {
		return null;
	}
}