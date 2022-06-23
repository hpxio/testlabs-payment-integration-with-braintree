package com.app.hpx.testlabs.integrator.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.client.model.request.CreateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.client.model.request.UpdateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.client.service.BraintreeCustomerService;
import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponseDTO;

@Component
public class BraintreeCustomerApiDelegate {

    private final BraintreeCustomerService customerService;

    @Autowired
    public BraintreeCustomerApiDelegate(BraintreeCustomerService customerService) {
        this.customerService = customerService;
    }

    public GetCustomerResponseDTO createCustomerDelegate(CreateBraintreeCustomerRequest request) {
        return customerService.createCustomer(request);
    }


    public String updateCustomerDelegate(UpdateBraintreeCustomerRequest request) {
        return customerService.updateCustomer(request);
    }


    public boolean removeCustomerDelegate(String customerId) {
        return customerService.removeCustomer(customerId);
    }

    public GetCustomerResponseDTO getCustomerDelegate(String customerId) {
        return customerService.getCustomer(customerId);
    }
}
