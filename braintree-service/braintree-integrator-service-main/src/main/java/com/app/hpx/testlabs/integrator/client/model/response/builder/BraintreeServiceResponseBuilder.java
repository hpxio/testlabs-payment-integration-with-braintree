package com.app.hpx.testlabs.integrator.client.model.response.builder;

public interface BraintreeServiceResponseBuilder<T, R> {
    R build(T request);
}
