package com.app.hpx.testlabs.integrator.model.response;

import com.app.hpx.testlabs.integrator.model.CustomerDetailsModel;

public class GetCustomerResponseDTO {

    private String customerId;

    private CustomerDetailsModel customerDetailsModel;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerDetailsModel getCustomerDetailsModel() {
        return customerDetailsModel;
    }

    public void setCustomerDetailsModel(CustomerDetailsModel customerDetailsModel) {
        this.customerDetailsModel = customerDetailsModel;
    }

    @Override
    public String toString() {
        return "GetCustomerResponseDTO{" + "customerId='" + customerId + '\'' + ", customerDetailsModel="
                   + customerDetailsModel + '}';
    }
}
