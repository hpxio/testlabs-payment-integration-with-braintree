package com.app.hpx.testlabs.integrator.exception.util;

import org.springframework.http.HttpStatus;

import com.app.hpx.testlabs.integrator.exception.ErrorDetails;
import com.app.hpx.testlabs.integrator.exception.IntegratorCommonException;
import com.app.hpx.testlabs.integrator.exception.IntegratorErrorCodes;

public class IntegratorExceptionUtil {

	private IntegratorExceptionUtil() {
		/* do nothing - avoid instantiation */
	}

	public static IntegratorCommonException buildException(
			int code, String message, String type, HttpStatus status) {
		ErrorDetails errorDetails = new ErrorDetails(code, message, type, status);
		return new IntegratorCommonException(errorDetails);
	}

	public static IntegratorCommonException buildException(IntegratorErrorCodes errorCode) {
		ErrorDetails errorDetails = new ErrorDetails(
				errorCode.getErrorCode(),
				errorCode.getErrorMessage(),
				errorCode.getErrorType(),
				errorCode.getStatus()
		);
		return new IntegratorCommonException(errorDetails);
	}
}