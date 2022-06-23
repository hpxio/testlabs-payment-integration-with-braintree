package com.app.hpx.testlabs.integrator.client.service;

public interface BraintreeInstrumentService {

    String addInstrument(String customerId, String paymentNonce);

    boolean deleteInstrument(String paymentToken);

    boolean checkIfDefaultInstrument(String token);
}
