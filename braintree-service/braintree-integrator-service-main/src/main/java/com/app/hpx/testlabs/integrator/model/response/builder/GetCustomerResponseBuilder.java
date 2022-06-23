package com.app.hpx.testlabs.integrator.model.response.builder;

import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponse;
import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponseDTO;

@Component
public class GetCustomerResponseBuilder implements
    ServiceResponseBuilder<GetCustomerResponseDTO, GetCustomerResponse> {

    @Override
    public GetCustomerResponse build(GetCustomerResponseDTO responseDTO) {
        return new GetCustomerResponse(responseDTO.getCustomerId(),
            responseDTO.getCustomerDetailsModel().getFirstName(),
            responseDTO.getCustomerDetailsModel().getLastName(),
            responseDTO.getCustomerDetailsModel().getEmailAddress(),
            responseDTO.getCustomerDetailsModel().getContactNumber());
    }
}
