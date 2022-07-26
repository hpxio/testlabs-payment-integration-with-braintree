package com.app.hpx.testlabs.integrator.exception;

import org.springframework.http.HttpStatus;

public class IntegratorCommonException extends RuntimeException {
	private ErrorDetails errorDetails;

	public IntegratorCommonException(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}

	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}
}