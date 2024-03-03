package com.beta.replyservice.services.validation;

import com.beta.replyservice.configuration.MessageConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestPayloadValidator implements Validator {

    @Autowired
    private MessageConfiguration config;

    @Override
    public boolean isValidInput(String input) {
        if (input == null) {
            return false;
        }

        int ruleMessageSeparatorIndex = input.indexOf(config.getSeparator());

        if (ruleMessageSeparatorIndex == -1) {
            return false;
        }

        String rules = input.substring(0, ruleMessageSeparatorIndex);

        return isValidRule(rules)
                && hasMessage(input, ruleMessageSeparatorIndex);
    }

    private boolean isValidRule(String input) {
        char CHAR_DIGIT_OFFSET = '0';

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int rule = currentChar - CHAR_DIGIT_OFFSET;

            if (isNumeric(rule) && isValidRuleRange(rule)) {
                continue;
            }

            return false;
        }

        return true;
    }

    private boolean isNumeric(int rule) {
        return rule >= 1 && rule <= 9;
    }

    private boolean isValidRuleRange(int rule) {
        int[] ruleRange = config.getRange();

        return rule >= ruleRange[0] && rule <= ruleRange[1];
    }

    private boolean hasMessage(String input, int separatorIndex) {
        return separatorIndex < input.length() - 1;
    }
}
