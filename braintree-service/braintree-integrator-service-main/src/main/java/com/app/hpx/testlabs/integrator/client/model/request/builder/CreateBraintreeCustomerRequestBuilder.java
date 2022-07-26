package com.app.hpx.testlabs.integrator.client.model.request.builder;

import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.client.model.request.CreateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequest;
import com.braintreegateway.CustomerRequest;

@Component
public class CreateBraintreeCustomerRequestBuilder implements
		CustomerRequestBuilder<CreateCustomerRequest, CreateBraintreeCustomerRequest> {

	@Override
	public CreateBraintreeCustomerRequest build(CreateCustomerRequest request) {
		CreateBraintreeCustomerRequest braintreeRequest = new CreateBraintreeCustomerRequest();
		CustomerRequest customerDetails = new CustomerRequest();

		customerDetails
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.phone(request.getContact())
				.email(request.getEmail());

		braintreeRequest.setCustomerRequest(customerDetails);
		return braintreeRequest;
	}
}