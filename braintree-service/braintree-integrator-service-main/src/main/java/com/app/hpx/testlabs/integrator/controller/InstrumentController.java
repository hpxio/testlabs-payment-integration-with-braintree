package com.app.hpx.testlabs.integrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.hpx.testlabs.integrator.service.InstrumentService;

@RestController
@RequestMapping("/payment/v1/instrument")
public class InstrumentController {

    private  static final String CUSTOMER_ID = "customer_id";
    private static final String PAYMENT_NONCE = "payment_nonce";

    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addInstrument(
        @RequestParam(name = CUSTOMER_ID) String customerId,
        @RequestParam(name = PAYMENT_NONCE) String paymentNonce){
        return instrumentService.addInstrument(customerId, paymentNonce);
    }
}
