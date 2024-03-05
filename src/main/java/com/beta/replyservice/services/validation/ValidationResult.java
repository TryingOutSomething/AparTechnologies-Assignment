package com.beta.replyservice.services.validation;

/**
 * A wrapper to provide more information to the user if their input contains errors
 */
public class ValidationResult {

    private final String errorMessage;
    private final boolean valid;

    /**
     * Instantiates a new Validation result.
     *
     * @param errorMessage the error message
     * @param valid        the valid
     */
    public ValidationResult(String errorMessage, boolean valid) {
        this.errorMessage = errorMessage;
        this.valid = valid;
    }

    /**
     * Gets error message.
     *
     * @return the error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Is valid boolean.
     *
     * @return the boolean
     */
    public boolean isValid() {
        return valid;
    }
}
