package com.app.hpx.testlabs.integrator.client.api;

import org.springframework.stereotype.Component;

import com.app.hpx.testlabs.integrator.client.service.BraintreeInstrumentService;

@Component
public class BraintreeInstrumentApiDelegate {

    private final BraintreeInstrumentService instrumentService;

    public BraintreeInstrumentApiDelegate(BraintreeInstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    public String addInstrumentDelegate(String customerId, String nonce) {
        return instrumentService.addInstrument(customerId, nonce);
    }

    public boolean updateInstrumentDelegate(String token) {
        return instrumentService.deleteInstrument(token);
    }

    public boolean deleteInstrumentDelegate(String token) {
        return instrumentService.checkIfDefaultInstrument(token);
    }
}
