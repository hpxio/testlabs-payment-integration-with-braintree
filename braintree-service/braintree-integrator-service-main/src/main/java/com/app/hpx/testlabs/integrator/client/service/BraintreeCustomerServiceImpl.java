package com.app.hpx.testlabs.integrator.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.client.config.BraintreeGatewayConfig;
import com.app.hpx.testlabs.integrator.client.model.request.CreateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.client.model.request.UpdateBraintreeCustomerRequest;
import com.app.hpx.testlabs.integrator.client.model.response.builder.BraintreeServiceResponseBuilder;
import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponseDTO;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Customer;
import com.braintreegateway.Result;
import com.braintreegateway.exceptions.NotFoundException;

@Component
public class BraintreeCustomerServiceImpl implements BraintreeCustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(BraintreeCustomerServiceImpl.class);

    private final BraintreeGatewayConfig gatewayConfig;

    private final BraintreeServiceResponseBuilder<Customer, GetCustomerResponseDTO> getCustomerResponseBuilder;

    @Autowired
    public BraintreeCustomerServiceImpl(BraintreeGatewayConfig gateway,
        BraintreeServiceResponseBuilder<Customer, GetCustomerResponseDTO> getCustomerResponseBuilder) {
        this.gatewayConfig = gateway;
        this.getCustomerResponseBuilder = getCustomerResponseBuilder;
    }

    @Override
    public GetCustomerResponseDTO createCustomer(CreateBraintreeCustomerRequest request) {
        BraintreeGateway gatewayInstance = gatewayConfig.getBraintreeGatewayInstance();
        Result<Customer> createCustomerResult = gatewayInstance.customer().create(request.getCustomerRequest());

        if (createCustomerResult.isSuccess()) {
            return getCustomerResponseBuilder.build(createCustomerResult.getTarget());
        } else {
            /* TODO : throw customer-creation application exception here */
            throw new RuntimeException("Error occurred while creating customer!");
        }
    }

    @Override
    public String updateCustomer(UpdateBraintreeCustomerRequest request) {
        BraintreeGateway gatewayInstance = gatewayConfig.getBraintreeGatewayInstance();
        Result<Customer> updateCustomerResult =
            gatewayInstance.customer()
                .update(request.getCustomerId(),
                    request.getCustomerRequest());

        if (updateCustomerResult.isSuccess()) {
            Customer resultTarget = updateCustomerResult.getTarget();
            return resultTarget.getId();
        } else {
            /* TODO : throw customer-modification application exception here */
            throw new RuntimeException("Error occurred while updating customer!");
        }
    }

    @Override
    public boolean removeCustomer(String customerId) {
        BraintreeGateway gatewayInstance = gatewayConfig.getBraintreeGatewayInstance();

        try {
            /* check if the customer with given ID exists */
            gatewayInstance.customer().find(customerId);

            /* issue delete request for given ID */
            Result<Customer> deleteCustomerResult = gatewayInstance.customer().delete(customerId);
            return deleteCustomerResult.isSuccess();

        } catch (NotFoundException nfe) {
            /* TODO : throw customer-deletion application exception here */
            throw new RuntimeException("Customer with given ID not found");
        } catch (Exception ex) {
            /* TODO : throw customer-deletion application exception here */
            throw new RuntimeException("Error occurred while deleting customer!");
        }
    }

    @Override
    public GetCustomerResponseDTO getCustomer(String customerId) {
        BraintreeGateway gatewayInstance = gatewayConfig.getBraintreeGatewayInstance();
        try {
            /* check if the customer with given ID exists */
            Customer customer = gatewayInstance.customer().find(customerId);
            LOG.info("Customer found, created on : {}", customer.getCreatedAt());

            return getCustomerResponseBuilder.build(customer);
        } catch (NotFoundException nfe) {
            /* TODO : throw customer-search application exception here */
            throw new RuntimeException("Customer with given ID not found");
        } catch (Exception ex) {
            /* TODO : throw customer-search application exception here */
            throw new RuntimeException("Error occurred while finding customer!");
        }
    }
}
