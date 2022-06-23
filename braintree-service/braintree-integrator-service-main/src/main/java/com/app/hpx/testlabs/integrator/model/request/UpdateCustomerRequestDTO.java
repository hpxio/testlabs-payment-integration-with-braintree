package com.app.hpx.testlabs.integrator.model.request;

import com.app.hpx.testlabs.integrator.model.CustomerDetailsModel;

public class UpdateCustomerRequestDTO {

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
        return "UpdateCustomerRequestDTO{" + "customerId='" + customerId + '\'' + ", customerDetailsModel="
                   + customerDetailsModel + '}';
    }
}
