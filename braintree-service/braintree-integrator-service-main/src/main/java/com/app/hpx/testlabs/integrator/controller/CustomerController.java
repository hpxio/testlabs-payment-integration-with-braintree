package com.app.hpx.testlabs.integrator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.hpx.testlabs.integrator.model.request.CreateCustomerRequest;
import com.app.hpx.testlabs.integrator.model.response.GetCustomerResponse;
import com.app.hpx.testlabs.integrator.service.CustomerService;

@RestController
@RequestMapping("/payment/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createCustomer(@Valid @RequestBody CreateCustomerRequest request){
        return customerService.createCustomer(request);
    }

    @GetMapping
    public GetCustomerResponse getCustomer(@RequestParam String customerId){
        return customerService.getCustomer(customerId);
    }
}
