package com.beta.replyservice.services.validation;

public class ValidationResult {

    private final String errorMessage;
    private final boolean valid;

    public ValidationResult(String errorMessage, boolean valid) {
        this.errorMessage = errorMessage;
        this.valid = valid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isValid() {
        return valid;
    }
}
