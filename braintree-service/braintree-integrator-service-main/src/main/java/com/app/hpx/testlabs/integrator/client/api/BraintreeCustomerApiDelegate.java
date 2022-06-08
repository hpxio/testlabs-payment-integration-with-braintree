package com.app.hpx.testlabs.integrator.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.client.service.BraintreeCustomerService;

@Component
public class BraintreeCustomerApiDelegate {

    private final BraintreeCustomerService customerService;

    @Autowired
    public BraintreeCustomerApiDelegate(BraintreeCustomerService customerService) {
        this.customerService = customerService;
    }

    public void createCustomerDelegate() {
        customerService.createCustomer(null);
    }


    public void updateCustomerDelegate() {

    }


    public void removeCustomerDelegate() {

    }


    public void getCustomerDelegate() {

    }
}
