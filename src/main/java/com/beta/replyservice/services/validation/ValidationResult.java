package com.beta.replyservice.services.validation;

import com.beta.replyservice.configuration.RequestErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidationResult {

    @Autowired
    private RequestErrorMessage requestErrorMessage;

    private final String errorMessage;
    private final boolean valid;

    public ValidationResult(String errorMessage, boolean valid) {
        this.errorMessage = errorMessage;
        this.valid = valid;
    }

    public String getErrorMessage() {
        return requestErrorMessage.getPrefix() + ". Reason: " + errorMessage;
    }

    public boolean isValid() {
        return valid;
    }
}
