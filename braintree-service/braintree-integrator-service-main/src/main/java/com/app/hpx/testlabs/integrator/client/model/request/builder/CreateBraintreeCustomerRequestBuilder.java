package com.app.hpx.testlabs.integrator.client.model.request.builder;

import org.springframework.stereotype.Component;

import com.braintreegateway.CustomerRequest;

import com.app.hpx.testlabs.integrator.client.model.request.CreateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.model.CustomerDetailsModel;
import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequestDTO;

@Component
public class CreateBraintreeCustomerRequestBuilder implements
    BraintreeServiceRequestBuilder<CreateCustomerRequestDTO, CreateBraintreeCustomerRequest> {

    @Override
    public CreateBraintreeCustomerRequest build(CreateCustomerRequestDTO request) {
        CreateBraintreeCustomerRequest createBraintreeCustomerRequest = new CreateBraintreeCustomerRequest();
        CustomerRequest customerRequest = new CustomerRequest();

        CustomerDetailsModel customerDetailsModel = request.getCustomerDetailsModel();

        customerRequest
            .firstName(customerDetailsModel.getFirstName())
            .lastName(customerDetailsModel.getLastName())
            .email(customerDetailsModel.getEmailAddress())
            .phone(customerDetailsModel.getContactNumber());

        createBraintreeCustomerRequest.setCustomerRequest(customerRequest);

        return createBraintreeCustomerRequest;
    }
}
