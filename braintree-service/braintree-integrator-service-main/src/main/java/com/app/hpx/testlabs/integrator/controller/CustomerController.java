package com.app.hpx.testlabs.integrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequest;
import com.app.hpx.testlabs.integrator.service.CustomerService;

@RestController
@RequestMapping("/payment/v1/rest/customer")
public class CustomerController {

	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createCustomer(@RequestBody CreateCustomerRequest request){
		return customerService.createCustomer(request);
	}
}