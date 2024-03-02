package com.beta.replyservice.services.validation;

import org.springframework.stereotype.Service;

@Service
public class RequestPayloadValidator implements Validator {

    private static final String SEPARATOR = "-"; //TODO: put in prop file

    @Override
    public boolean isValidInput(String input) {
        return input.contains(SEPARATOR) && isNumeric(input);
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
