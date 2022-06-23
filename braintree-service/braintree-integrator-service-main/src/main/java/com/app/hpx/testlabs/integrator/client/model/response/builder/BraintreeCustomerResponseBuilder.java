package com.app.hpx.testlabs.integrator.client.model.response.builder;

import org.springframework.stereotype.Component;

import com.braintreegateway.Customer;

import com.app.hpx.testlabs.integrator.model.CustomerDetailsModel;
import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponseDTO;

@Component
public class BraintreeCustomerResponseBuilder
    implements BraintreeServiceResponseBuilder<Customer, GetCustomerResponseDTO> {

    @Override
    public GetCustomerResponseDTO build(Customer customer) {

        GetCustomerResponseDTO getCustomerResponseDTO = new GetCustomerResponseDTO();
        CustomerDetailsModel customerDetailsModel = new CustomerDetailsModel();

        customerDetailsModel.setFirstName(customer.getFirstName());
        customerDetailsModel.setLastName(customer.getLastName());

        customerDetailsModel.setEmailAddress(customer.getEmail());
        customerDetailsModel.setContactNumber(customer.getPhone());

        customerDetailsModel.setCreatedTimestamp(String.valueOf(customer.getCreatedAt().getTimeInMillis()));
        customerDetailsModel.setUpdatedTimestamp(String.valueOf(customer.getUpdatedAt().getTimeInMillis()));

        getCustomerResponseDTO.setCustomerDetailsModel(customerDetailsModel);
        getCustomerResponseDTO.setCustomerId(customer.getId());

        return getCustomerResponseDTO;
    }
}
