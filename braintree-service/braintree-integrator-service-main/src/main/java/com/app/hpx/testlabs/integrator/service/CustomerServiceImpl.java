package com.app.hpx.testlabs.integrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hpx.testlabs.integrator.client.api.service.BraintreeCustomerService;
import com.app.hpx.testlabs.integrator.client.model.request.CreateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.client.model.request.builder.CustomerRequestBuilder;
import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequest;
import com.app.hpx.testlabs.integrator.model.response.CreateCustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final BraintreeCustomerService service;

	private final CustomerRequestBuilder<CreateCustomerRequest, CreateBraintreeCustomerRequest> builder;

	@Autowired
	public CustomerServiceImpl(
			BraintreeCustomerService service,
			CustomerRequestBuilder<CreateCustomerRequest, CreateBraintreeCustomerRequest> builder) {
		this.service = service;
		this.builder = builder;
	}

	@Override
	public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
		CreateBraintreeCustomerRequest customerRequest = builder.build(request);
		String customerId = service.createCustomer(customerRequest);

		/* store customerId data to local-db (non-pci data only) */
		return new CreateCustomerResponse(customerId);
	}
}