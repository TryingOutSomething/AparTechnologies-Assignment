package com.beta.replyservice.services.validation;

import com.beta.replyservice.configuration.RequestErrorMessage;
import com.beta.replyservice.configuration.RuleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestPayloadValidator implements Validator {

    @Autowired
    private RuleConfiguration config;

    @Autowired
    private RequestErrorMessage errorMessage;

    @Override
    public ValidationResult isValidInput(String input) {
        if (input == null) {
            return new ValidationResult(errorMessage.getNullInput(), false);
        }

        int ruleMessageSeparatorIndex = input.indexOf(config.getSeparator());

        if (ruleMessageSeparatorIndex == -1) {
            return new ValidationResult(errorMessage.getNoSeparator(), false);
        }

        String rules = input.substring(0, ruleMessageSeparatorIndex);
        ValidationResult rulesValidationResult = isValidRule(rules);

        if (!rulesValidationResult.isValid()) {
            String message = errorMessage.getInvalidRule() + ": " + rulesValidationResult.getErrorMessage();
            return new ValidationResult(message, false);
        }

        if (!hasMessage(input, ruleMessageSeparatorIndex)) {
            return new ValidationResult(errorMessage.getEmptyMessage(), false);
        }

        return new ValidationResult(null, true);
    }

    private ValidationResult isValidRule(String input) {
        int inputLength = input.length();

        if (inputLength < config.getMinLength()) {
            return new ValidationResult(errorMessage.getInvalidRuleLength(), false);
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

            return new ValidationResult(message, false);
        }

        return new ValidationResult(null, true);
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
}
