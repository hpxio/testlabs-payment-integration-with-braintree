package com.app.hpx.testlabs.integrator.client.service;

import com.app.hpx.testlabs.integrator.client.model.request.CreateCustomerRequest;
import com.app.hpx.testlabs.integrator.client.model.request.UpdateCustomerRequest;
import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponseDTO;

public interface BraintreeCustomerService {

    String createCustomer(CreateCustomerRequest request);

    String updateCustomer(UpdateCustomerRequest request);

    boolean removeCustomer(String customerId);

    GetCustomerResponseDTO getCustomer(String customerId);

}
