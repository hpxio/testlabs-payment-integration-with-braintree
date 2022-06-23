package com.app.hpx.testlabs.integrator.service;

import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequest;
import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponse;

public interface CustomerService {
    String createCustomer(CreateCustomerRequest request);
    void updateCustomer();
    void deleteCustomer();
    GetCustomerResponse getCustomer(String customerId);
}
