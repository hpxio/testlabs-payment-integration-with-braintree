package com.app.hpx.testlabs.integrator.model.request;

import com.app.hpx.testlabs.integrator.model.CustomerDetailsModel;

public class CreateCustomerRequestDTO {

    private CustomerDetailsModel customerDetailsModel;

    public CustomerDetailsModel getCustomerDetailsModel() {
        return customerDetailsModel;
    }

    public void setCustomerDetailsModel(CustomerDetailsModel customerDetailsModel) {
        this.customerDetailsModel = customerDetailsModel;
    }

    @Override
    public String toString() {
        return "CreateCustomerRequestDTO{" + "customerDetailsModel=" + customerDetailsModel + '}';
    }
}
