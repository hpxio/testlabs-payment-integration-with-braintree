package com.app.hpx.testlabs.integrator.client.model.request;

import com.braintreegateway.CustomerRequest;

public class CreateCustomerRequest {

    private CustomerRequest customerRequest;

    public CustomerRequest getCustomerRequest() {
        return customerRequest;
    }

    public void setCustomerRequest(CustomerRequest customerRequest) {
        this.customerRequest = customerRequest;
    }
}
