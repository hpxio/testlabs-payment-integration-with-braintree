package com.app.hpx.testlabs.integrator.model.request.builder;

import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.model.CustomerDetailsModel;
import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequest;
import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequestDTO;

@Component
public class CreateCustomerRequestBuilder
    implements ServiceRequestBuilder<CreateCustomerRequest, CreateCustomerRequestDTO> {

    @Override
    public CreateCustomerRequestDTO build(CreateCustomerRequest request) {
        CreateCustomerRequestDTO customerRequestDTO = new CreateCustomerRequestDTO();
        CustomerDetailsModel detailsModel = new CustomerDetailsModel();

        detailsModel.setFirstName(request.getFirstName());
        detailsModel.setLastName(request.getLastName());
        detailsModel.setEmailAddress(request.getEmailAddress());
        detailsModel.setContactNumber(request.getContactNumber());

        customerRequestDTO.setCustomerDetailsModel(detailsModel);
        return customerRequestDTO;
    }
}
