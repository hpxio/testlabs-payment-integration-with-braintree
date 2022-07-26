package com.app.hpx.testlabs.integrator.service;

import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequest;
import com.app.hpx.testlabs.integrator.model.response.CreateCustomerResponse;

public interface CustomerService {
	CreateCustomerResponse createCustomer(CreateCustomerRequest request);
}
