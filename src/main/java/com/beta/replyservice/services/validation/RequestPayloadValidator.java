package com.beta.replyservice.services.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestPayloadValidator implements Validator {

    @Autowired
    private String ruleMessageSeparator;

    @Override
    public boolean isValidInput(String input) {
        if (input == null) {
            return false;
        }

        int ruleMessageSeparatorIndex = input.indexOf(ruleMessageSeparator);

        if (ruleMessageSeparatorIndex == -1) {
            return false;
        }

        return isNumeric(input.substring(0, ruleMessageSeparatorIndex))
                && hasMessage(input, ruleMessageSeparatorIndex);
    }

    private boolean isNumeric(String input) {
        int CHAR_DIGIT_ONE_ASCII_VALUE = 49;
        int CHAR_DIGIT_NINE_ASCII_VALUE = 57;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c >= CHAR_DIGIT_ONE_ASCII_VALUE
                    && c <= CHAR_DIGIT_NINE_ASCII_VALUE) {
                continue;
            }

            return false;
        }

        return true;
    }

    private boolean hasMessage(String input, int separatorIndex) {
        return separatorIndex < input.length() - 1;
    }
}
