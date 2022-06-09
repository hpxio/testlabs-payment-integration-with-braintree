package com.app.hpx.testlabs.integrator.client.model.request.builder;

import org.springframework.stereotype.Component;

import com.braintreegateway.CustomerRequest;

import com.app.hpx.testlabs.integrator.client.model.request.CreateCustomerRequest;
import com.app.hpx.testlabs.integrator.model.CustomerDetailsModel;
import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequestDTO;

@Component
public class CreateCustomerRequestBuilder implements
    BraintreeServiceRequestBuilder<CreateCustomerRequestDTO, CreateCustomerRequest> {

    @Override
    public CreateCustomerRequest build(CreateCustomerRequestDTO request) {
        CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
        CustomerRequest customerRequest = new CustomerRequest();

        CustomerDetailsModel customerDetailsModel = request.getCustomerDetailsModel();

        customerRequest
            .firstName(customerDetailsModel.getFirstName())
            .lastName(customerDetailsModel.getLastName())
            .email(customerDetailsModel.getEmailAddress())
            .phone(customerDetailsModel.getContactNumber());

        createCustomerRequest.setCustomerRequest(customerRequest);

        return createCustomerRequest;
    }
}
