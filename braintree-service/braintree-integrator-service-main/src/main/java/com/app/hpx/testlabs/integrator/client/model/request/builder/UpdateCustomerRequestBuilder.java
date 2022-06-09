package com.app.hpx.testlabs.integrator.client.model.request.builder;

import org.springframework.stereotype.Component;

import com.braintreegateway.CustomerRequest;

import com.app.hpx.testlabs.integrator.client.model.request.UpdateCustomerRequest;
import com.app.hpx.testlabs.integrator.model.CustomerDetailsModel;
import com.app.hpx.testlabs.integrator.model.request.UpdateCustomerRequestDTO;

@Component
public class UpdateCustomerRequestBuilder
    implements BraintreeServiceRequestBuilder<UpdateCustomerRequestDTO, UpdateCustomerRequest> {

    @Override
    public UpdateCustomerRequest build(UpdateCustomerRequestDTO request) {
        UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest();
        CustomerRequest customerRequest = new CustomerRequest();

        CustomerDetailsModel customerDetailsModel = request.getCustomerDetailsModel();

        customerRequest
            .firstName(customerDetailsModel.getFirstName())
            .lastName(customerDetailsModel.getLastName())
            .email(customerDetailsModel.getEmailAddress())
            .phone(customerDetailsModel.getContactNumber());

        updateCustomerRequest.setCustomerId(request.getCustomerId());
        updateCustomerRequest.setCustomerRequest(customerRequest);

        return updateCustomerRequest;
    }
}
