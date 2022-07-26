package com.app.hpx.testlabs.integrator.exception;

import org.springframework.http.HttpStatus;

public enum IntegratorErrorCodes {
	CUSTOMER_NOT_CREATED(2, "Customer creation failed due to service error", HttpStatus.NOT_MODIFIED.name(),
			HttpStatus.NOT_MODIFIED);

	private int errorCode;
	private String errorMessage;
	private String errorType;
	private HttpStatus status;

	private IntegratorErrorCodes() {
		/* do nothing - avoid instantiation */
	}

	IntegratorErrorCodes(int errorCode, String errorMessage, String errorType, HttpStatus status) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorType = errorType;
		this.status = status;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorType() {
		return errorType;
	}

	public HttpStatus getStatus() {
		return status;
	}
}