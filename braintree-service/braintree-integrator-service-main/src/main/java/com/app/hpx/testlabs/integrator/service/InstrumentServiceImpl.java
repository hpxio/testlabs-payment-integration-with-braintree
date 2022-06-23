package com.app.hpx.testlabs.integrator.service;

import org.springframework.stereotype.Service;

import com.app.hpx.testlabs.integrator.client.api.BraintreeInstrumentApiDelegate;
import com.app.hpx.testlabs.integrator.utils.EncodeDecodeUtil;

@Service
public class InstrumentServiceImpl implements InstrumentService {

    private final BraintreeInstrumentApiDelegate instrumentApiDelegate;

    public InstrumentServiceImpl(BraintreeInstrumentApiDelegate instrumentApiDelegate) {
        this.instrumentApiDelegate = instrumentApiDelegate;
    }

    @Override
    public String addInstrument(String customerId, String paymentNonce) {
        try {
            String paymentTokenPlainText = instrumentApiDelegate.addInstrumentDelegate(customerId, paymentNonce);
            String paymentTokenEncoded = EncodeDecodeUtil.encodeString(paymentTokenPlainText);

            /* TODO: store the encoded token for transactions */
            return paymentTokenEncoded;
        } catch (Exception ex) {
            /* TODO : replace generic implementation with application exception */
            throw new RuntimeException(" Re-throw exception from API");
        }
    }
}
