package com.app.hpx.testlabs.integrator.client.model.request;

import com.braintreegateway.CustomerRequest;

public class UpdateBraintreeCustomerRequest {

    private String customerId;

    private CustomerRequest customerRequest;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerRequest getCustomerRequest() {
        return customerRequest;
    }

    public void setCustomerRequest(CustomerRequest customerRequest) {
        this.customerRequest = customerRequest;
    }

    @Override
    public String toString() {
        return "UpdateCustomerRequest{" + "customerId='" + customerId + '\'' + ", customerRequest=" + customerRequest
                   + '}';
    }
}
