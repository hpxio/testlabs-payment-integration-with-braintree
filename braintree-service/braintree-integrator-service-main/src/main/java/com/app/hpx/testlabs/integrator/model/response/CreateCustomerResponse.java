package com.app.hpx.testlabs.integrator.model.response;

public class CreateCustomerResponse {
	private String customerId;

	public CreateCustomerResponse(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
