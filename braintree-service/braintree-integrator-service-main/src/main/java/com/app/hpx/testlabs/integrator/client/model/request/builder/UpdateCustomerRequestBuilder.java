package com.app.hpx.testlabs.integrator.client.model.request.builder;

import org.springframework.stereotype.Component;

import com.braintreegateway.CustomerRequest;

import com.app.hpx.testlabs.integrator.client.model.request.UpdateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.model.CustomerDetailsModel;
import com.app.hpx.testlabs.integrator.model.request.UpdateCustomerRequestDTO;

@Component
public class UpdateCustomerRequestBuilder
    implements BraintreeServiceRequestBuilder<UpdateCustomerRequestDTO, UpdateBraintreeCustomerRequest> {

    @Override
    public UpdateBraintreeCustomerRequest build(UpdateCustomerRequestDTO request) {
        UpdateBraintreeCustomerRequest updateBraintreeCustomerRequest = new UpdateBraintreeCustomerRequest();
        CustomerRequest customerRequest = new CustomerRequest();

        CustomerDetailsModel customerDetailsModel = request.getCustomerDetailsModel();

        customerRequest
            .firstName(customerDetailsModel.getFirstName())
            .lastName(customerDetailsModel.getLastName())
            .email(customerDetailsModel.getEmailAddress())
            .phone(customerDetailsModel.getContactNumber());

        updateBraintreeCustomerRequest.setCustomerId(request.getCustomerId());
        updateBraintreeCustomerRequest.setCustomerRequest(customerRequest);

        return updateBraintreeCustomerRequest;
    }
}
