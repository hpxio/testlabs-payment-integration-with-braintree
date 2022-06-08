package com.app.hpx.testlabs.integrator.client.service;

import com.braintreegateway.Customer;
import com.braintreegateway.CustomerRequest;

public interface BraintreeCustomerService {

    String createCustomer(CustomerRequest customerRequest);

    String updateCustomer(String customerId, CustomerRequest customerRequest);

    boolean removeCustomer(String customerId);

    Customer getCustomer(String customerId);

}
