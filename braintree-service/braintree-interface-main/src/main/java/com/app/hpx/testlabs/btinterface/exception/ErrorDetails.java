package com.app.hpx.testlabs.btinterface.exception;

public class ErrorDetails {
    private String httpErrorCode;
    private String httpErrorMessage;
    private String errorDescription;

    public ErrorDetails(String httpErrorCode, String httpErrorMessage, String errorDescription) {
        this.httpErrorCode = httpErrorCode;
        this.httpErrorMessage = httpErrorMessage;
        this.errorDescription = errorDescription;
    }

    public String getHttpErrorCode() {
        return httpErrorCode;
    }

    public void setHttpErrorCode(String httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }

    public String getHttpErrorMessage() {
        return httpErrorMessage;
    }

    public void setHttpErrorMessage(String httpErrorMessage) {
        this.httpErrorMessage = httpErrorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" + "httpErrorCode='" + httpErrorCode + '\'' + ", httpErrorMessage='" + httpErrorMessage
                   + '\'' + ", errorDescription='" + errorDescription + '\'' + '}';
    }
}
