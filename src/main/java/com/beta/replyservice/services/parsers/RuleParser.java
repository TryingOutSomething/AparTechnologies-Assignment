package com.beta.replyservice.services.parsers;

import org.springframework.stereotype.Service;

@Service
public class RuleParser implements Parser<Integer, String> {

    private static final String SEPARATOR = "-"; //TODO: put in prop file

    @Override
    public Integer getValue(String input) {
        int separatorIndex = input.indexOf(SEPARATOR);

        return Integer.parseInt(input.substring(0, separatorIndex));
    }
}
