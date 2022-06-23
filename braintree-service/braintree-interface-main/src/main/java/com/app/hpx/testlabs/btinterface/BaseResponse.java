package com.app.hpx.testlabs.btinterface;

import java.util.Objects;

import com.app.hpx.testlabs.btinterface.exception.ErrorDetails;

public class BaseResponse {
    private ErrorDetails errorDetails;

    public boolean hasError(){
        return Objects.nonNull(this.errorDetails);
    }

    public ErrorDetails getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(ErrorDetails errorDetails) {
        this.errorDetails = errorDetails;
    }
}
