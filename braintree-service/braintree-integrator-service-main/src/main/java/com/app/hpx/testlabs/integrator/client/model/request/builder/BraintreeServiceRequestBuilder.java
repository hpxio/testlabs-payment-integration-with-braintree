package com.app.hpx.testlabs.integrator.client.model.request.builder;

public interface BraintreeServiceRequestBuilder <T, R> {
    R build(T request);
}
