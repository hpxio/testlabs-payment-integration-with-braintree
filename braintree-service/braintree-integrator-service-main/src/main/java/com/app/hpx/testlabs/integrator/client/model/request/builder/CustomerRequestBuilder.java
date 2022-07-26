package com.app.hpx.testlabs.integrator.client.model.request.builder;

public interface CustomerRequestBuilder<T, R> {
	R build(T request);
}