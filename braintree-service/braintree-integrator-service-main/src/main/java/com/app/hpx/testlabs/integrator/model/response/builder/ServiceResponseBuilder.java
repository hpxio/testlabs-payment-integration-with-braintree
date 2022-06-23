package com.app.hpx.testlabs.integrator.model.response.builder;

public interface ServiceResponseBuilder <T, R>{
    R build(T request);
}
