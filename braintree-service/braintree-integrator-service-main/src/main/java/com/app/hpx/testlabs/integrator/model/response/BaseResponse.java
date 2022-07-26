package com.app.hpx.testlabs.integrator.model.response;

import java.util.Objects;

import com.app.hpx.testlabs.integrator.exception.ErrorDetails;

public class BaseResponse {
	ErrorDetails errorDetails = new ErrorDetails();

	public boolean hasError(){
		return Objects.nonNull(errorDetails);
	}

	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}
}