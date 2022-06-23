package com.app.hpx.testlabs.integrator.model.request.builder;

public interface ServiceRequestBuilder <T, R>{
    R build(T request);
}
