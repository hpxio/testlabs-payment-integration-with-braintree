package com.app.hpx.testlabs.integrator.exception;

import org.springframework.http.HttpStatus;

public class ErrorDetails {

	private int errorCode;

	private String errorMessage;

	private String errorType;

	private HttpStatus status;

	public ErrorDetails() {
		/* do nothing */
	}

	public ErrorDetails(int errorCode, String errorMessage, String errorType, HttpStatus status) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorType = errorType;
		this.status = status;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}