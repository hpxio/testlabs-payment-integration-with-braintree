package com.app.hpx.testlabs.integrator.client.service;

import com.app.hpx.testlabs.integrator.client.model.request.CreateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.client.model.request.UpdateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponseDTO;

public interface BraintreeCustomerService {

    GetCustomerResponseDTO createCustomer(CreateBraintreeCustomerRequest request);

    String updateCustomer(UpdateBraintreeCustomerRequest request);

    boolean removeCustomer(String customerId);

    GetCustomerResponseDTO getCustomer(String customerId);

}
