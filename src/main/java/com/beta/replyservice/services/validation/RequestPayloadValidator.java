package com.beta.replyservice.services.validation;

import com.beta.replyservice.configuration.RuleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestPayloadValidator implements Validator {

    @Autowired
    private RuleConfiguration config;

    @Override
    public ValidationResult isValidInput(String input) {
        if (input == null) {
            return new ValidationResult("", false);
        }

        int ruleMessageSeparatorIndex = input.indexOf(config.getSeparator());

        if (ruleMessageSeparatorIndex == -1) {
            return new ValidationResult("", false);
        }

        String rules = input.substring(0, ruleMessageSeparatorIndex);

        if (!isValidRule(rules)) {
            return new ValidationResult("", false);
        }

        if (!hasMessage(input, ruleMessageSeparatorIndex)) {
            return new ValidationResult("", false);
        }

        return new ValidationResult(null, true);
    }

    private boolean isValidRule(String input) {
        int inputLength = input.length();

        if (inputLength < config.getMinLength()) {
            return false;
        }

        char CHAR_DIGIT_OFFSET = '0';

        for (int i = 0; i < inputLength; i++) {
            char currentChar = input.charAt(i);
            int rule = currentChar - CHAR_DIGIT_OFFSET;

            if (isNumeric(rule) && isValidRule(rule)) {
                continue;
            }

            return false;
        }

        return true;
    }

    private boolean isNumeric(int rule) {
        return rule >= 1 && rule <= 9;
    }

    private boolean isValidRule(int rule) {
        return config.getWhitelist().contains(rule);
    }

    private boolean hasMessage(String input, int separatorIndex) {
        return separatorIndex < input.length() - 1;
    }
}
