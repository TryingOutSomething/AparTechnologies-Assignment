package com.beta.replyservice.services.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestPayloadValidator implements Validator {

    @Autowired
    private String ruleMessageSeparator;

    @Override
    public boolean isValidInput(String input) {
        return input.contains(ruleMessageSeparator) && isNumeric(input);
    }

    private boolean isNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c >= 1 && c <=9) {
                continue;
            }

            return false;
        }

        return true;
    }
}
