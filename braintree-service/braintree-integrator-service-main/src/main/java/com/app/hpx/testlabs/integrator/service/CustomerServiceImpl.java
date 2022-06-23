package com.app.hpx.testlabs.integrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hpx.testlabs.integrator.client.api.BraintreeCustomerApiDelegate;
import com.app.hpx.testlabs.integrator.client.model.request.CreateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.client.model.request.builder.BraintreeServiceRequestBuilder;

import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequest;
import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequestDTO;
import com.app.hpx.testlabs.integrator.model.request.builder.ServiceRequestBuilder;
import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponse;
import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponseDTO;
import com.app.hpx.testlabs.integrator.model.response.builder.ServiceResponseBuilder;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final BraintreeCustomerApiDelegate customerApiDelegate;

    private final ServiceResponseBuilder<GetCustomerResponseDTO, GetCustomerResponse> serviceResponseBuilder;

    private final ServiceRequestBuilder<CreateCustomerRequest, CreateCustomerRequestDTO> serviceRequestBuilder;

    private final BraintreeServiceRequestBuilder<CreateCustomerRequestDTO, CreateBraintreeCustomerRequest>
        braintreeCustomerRequestBuilder;

    @Autowired
    public CustomerServiceImpl(BraintreeCustomerApiDelegate customerApiDelegate,
        ServiceResponseBuilder<GetCustomerResponseDTO, GetCustomerResponse> serviceResponseBuilder,
        ServiceRequestBuilder<CreateCustomerRequest, CreateCustomerRequestDTO> serviceRequestBuilder,
        BraintreeServiceRequestBuilder<CreateCustomerRequestDTO, CreateBraintreeCustomerRequest> braintreeCustomerRequestBuilder) {

        this.customerApiDelegate = customerApiDelegate;
        this.serviceRequestBuilder = serviceRequestBuilder;
        this.serviceResponseBuilder = serviceResponseBuilder;
        this.braintreeCustomerRequestBuilder = braintreeCustomerRequestBuilder;
    }

    @Override
    public String createCustomer(CreateCustomerRequest request) {
        CreateCustomerRequestDTO requestDTO = serviceRequestBuilder.build(request);
        CreateBraintreeCustomerRequest braintreeCustomerRequest = braintreeCustomerRequestBuilder.build(requestDTO);

        try {
            GetCustomerResponseDTO customer = customerApiDelegate.createCustomerDelegate(braintreeCustomerRequest);

            /* TODO: add logic to persists customer data */
            return customer.getCustomerId();
        } catch (Exception ex) {
            /* TODO: replace generic implementation with application exception */
            throw new RuntimeException("Re-throw API exception here!");
        }
    }

    @Override
    public void updateCustomer() {

    }

    @Override
    public void deleteCustomer() {

    }

    @Override
    public GetCustomerResponse getCustomer(String customerId) {
        try {
            GetCustomerResponseDTO customer = customerApiDelegate.getCustomerDelegate(customerId);
            return serviceResponseBuilder.build(customer);
        } catch (Exception ex) {
            /* TODO: replace generic implementation with application exception */
            throw new RuntimeException("Re-throw API exception here!");
        }
    }
}
