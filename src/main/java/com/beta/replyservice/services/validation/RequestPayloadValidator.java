package com.beta.replyservice.services.validation;

import com.beta.replyservice.configuration.RequestErrorMessage;
import com.beta.replyservice.configuration.RuleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The main class to validate the user's input message
 */
@Service
public class RequestPayloadValidator implements Validator {

    @Autowired
    private RuleConfiguration config;

    @Autowired
    private RequestErrorMessage errorMessage;

    /**
     * Performs the validation check on the user's input
     *
     * @param input the user's input
     * @return the result of the validation
     */
    @Override
    public ValidationResult isValidInput(String input) {
        if (input == null) {
            return generateResult(false, errorMessage.getNullInput(), true);
        }

        int ruleMessageSeparatorIndex = input.indexOf(config.getSeparator());

        if (ruleMessageSeparatorIndex == -1) {
            return generateResult(false, errorMessage.getNoSeparator(), true);
        }

        String rules = input.substring(0, ruleMessageSeparatorIndex);
        ValidationResult rulesValidationResult = isValidRule(rules);

        if (!rulesValidationResult.isValid()) {
            String message = errorMessage.getInvalidRule() + rulesValidationResult.getErrorMessage();
            return generateResult(false, message, true);
        }

        if (!hasMessage(input, ruleMessageSeparatorIndex)) {
            return generateResult(false, errorMessage.getEmptyMessage(), true);
        }

        return generateResult(true, null, false);
    }

    private ValidationResult isValidRule(String input) {
        int inputLength = input.length();

        if (inputLength < config.getMinLength()) {
            return generateResult(false, errorMessage.getInvalidRuleLength(), false);
        }

        char CHAR_DIGIT_OFFSET = '0';

        for (int i = 0; i < inputLength; i++) {
            char currentChar = input.charAt(i);
            int rule = currentChar - CHAR_DIGIT_OFFSET;

            boolean isNumeric = isNumeric(rule);
            boolean isWhiteListed = ruleIsWhiteListed(rule);

            if (isNumeric && isWhiteListed) {
                continue;
            }

            String message = !isNumeric
                    ? errorMessage.getRuleNotNumeric()
                    : errorMessage.getRuleNotWhitelisted() + " For " + rule;

            return generateResult(false, message, false);
        }

        return generateResult(true, null, false);
    }

    private boolean isNumeric(int rule) {
        return rule >= 1 && rule <= 9;
    }

    private boolean ruleIsWhiteListed(int rule) {
        return config.getWhitelist().contains(rule);
    }

    private boolean hasMessage(String input, int separatorIndex) {
        return separatorIndex < input.length() - 1;
    }

    /**
     * A helper function that generates the validation result object
     *
     * @param isValid        the validation result
     * @param message        error message if any. Else null
     * @param requiresPrefix prepends a default message referenced in application.properties file to the current message
     */
    private ValidationResult generateResult(boolean isValid, String message, boolean requiresPrefix) {
        if (isValid) {
            return new ValidationResult(null, true);
        }

        String prefixMessage = requiresPrefix
                ? errorMessage.getPrefix() + " " : "";

        return new ValidationResult(prefixMessage + message, false);
    }
}
