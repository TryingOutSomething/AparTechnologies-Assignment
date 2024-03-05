package com.beta.replyservice.services.validation;

public interface Validator {
//    String parse(String input);
    ValidationResult isValidInput(String input);
}
