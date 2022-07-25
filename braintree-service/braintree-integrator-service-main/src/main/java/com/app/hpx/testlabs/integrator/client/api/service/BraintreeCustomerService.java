package com.app.hpx.testlabs.integrator.client.api.service;

import com.app.hpx.testlabs.integrator.client.model.request.CreateBraintreeCustomerRequest;

public interface BraintreeCustomerService {
	String createCustomer(CreateBraintreeCustomerRequest request);
}
